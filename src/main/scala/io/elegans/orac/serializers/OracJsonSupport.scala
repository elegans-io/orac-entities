package io.elegans.orac.serializers

/**
  * Created by Angelo Leto <angelo.leto@elegans.io> on 27/06/16.
  */

import akka.http.scaladsl.common.{EntityStreamingSupport, JsonEntityStreamingSupport}
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.stream.scaladsl.Flow
import akka.util.ByteString
import io.elegans.orac.entities._
import spray.json._

trait OracJsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  private[this] val start: ByteString = ByteString.empty
  private[this] val sep: ByteString = ByteString("\n")
  private[this] val end: ByteString = ByteString.empty

  implicit val jsonStreamingSupport: JsonEntityStreamingSupport =
    EntityStreamingSupport.json(1024 * 1024) // max object size 1MB
      .withFramingRendererFlow(Flow[ByteString].intersperse(start, sep, end).asJava)
      .withParallelMarshalling(parallelism = 8, unordered = true)

  implicit val updateActionFormat = jsonFormat8(UpdateAction)
  implicit val actionFormat = jsonFormat9(Action)
  implicit val actionSearchFormat = jsonFormat10(ActionSearch)
  implicit val actionsFormat = jsonFormat1(Actions)
  implicit val numericalPropertiesFormat = jsonFormat2(NumericalProperties)
  implicit val timestampPropertiesFormat = jsonFormat2(TimestampProperties)
  implicit val stringPropertiesFormat = jsonFormat2(StringProperties)
  implicit val geoPointFormat = jsonFormat2(OracGeoPoint)
  implicit val geoPointPropertiesFormat = jsonFormat2(GeoPointProperties)
  implicit val itemPropertiesFormat = jsonFormat5(OracProperties)
  implicit val updateItemFormat = jsonFormat5(UpdateItem)
  implicit val itemFormat = jsonFormat6(Item)
  implicit val itemSearchFormat = jsonFormat6(ItemSearch)
  implicit val itemListFormat = jsonFormat1(Items)
  implicit val updateOracUserFormat = jsonFormat5(UpdateOracUser)
  implicit val oracUserFormat = jsonFormat6(OracUser)
  implicit val oracUserSearchFormat = jsonFormat5(OracUserSearch)
  implicit val oracUsersFormat = jsonFormat1(OracUsers)
  implicit val returnMessageDataFormat = jsonFormat2(ReturnMessageData)
  implicit val updateDocumentResultFormat = jsonFormat5(UpdateDocumentResult)
  implicit val indexManagementResponseFormat = jsonFormat1(IndexManagementResponse)
  implicit val indexDocumentResultFormat = jsonFormat3(IndexDocumentResult)
  implicit val deleteDocumentResultFormat = jsonFormat3(DeleteDocumentResult)
  implicit val deleteDocumentsResultFormat = jsonFormat2(DeleteDocumentsResult)
  implicit val failedShardFormat = jsonFormat4(FailedShard)
  implicit val refreshIndexResultFormat = jsonFormat5(RefreshIndexResult)
  implicit val refreshIndexResultsFormat = jsonFormat1(RefreshIndexResults)
  implicit val recommendationFormat = jsonFormat8(Recommendation)
  implicit val recommendationsFormat = jsonFormat1(Recommendations)
  implicit val updateRecommendationFormat = jsonFormat7(UpdateRecommendation)
  implicit val recommendationHistoryFormat = jsonFormat11(RecommendationHistory)
  implicit val recommendationsHistoryFormat = jsonFormat1(RecommendationsHistory)
  implicit val updateRecommendationHistoryFormat = jsonFormat10(UpdateRecommendationHistory)
}
