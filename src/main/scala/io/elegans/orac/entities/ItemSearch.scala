package io.elegans.orac.entities

/**
  * Created by Angelo Leto <angelo.leto@elegans.io> on 27/03/18.
  */

case class ItemSearch(from: Option[Int],
                      size: Option[Int],
                      min_score: Option[Float] = Option.empty,
                      id: Option[String] = Option.empty,
                      name: Option[String] = Option.empty,
                      category: Option[String] = Option.empty,
                      description: Option[String] = Option.empty,
                      props: Option[OracProperties] = Option.empty,
                      random: Option[Boolean] = Option.empty
                     )
