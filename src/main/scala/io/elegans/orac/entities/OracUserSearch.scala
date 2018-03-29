package io.elegans.orac.entities

/**
  * Created by Angelo Leto <angelo.leto@elegans.io> on 27/03/18.
  */

case class OracUserSearch(
                           name: Option[String] = Option.empty,
                           email: Option[String] = Option.empty,
                           phone: Option[String] = Option.empty,
                           timestamp_from: Option[Long] = Option.empty, /** item timestamp: from */
                           timestamp_to: Option[Long] = Option.empty /** item timestamp: to */
                         )
