package io.elegans.orac.entities

/**
  * Created by Angelo Leto <angelo.leto@elegans.io> on 27/03/18.
  */

case class ItemSearch(
                      name: Option[String] = Option.empty,
                      category: Option[String] = Option.empty,
                      description: Option[String] = Option.empty,
                      random: Option[Boolean] = Option.empty,
                      timestamp_from: Option[Long] = Option.empty, /** item timestamp: from */
                      timestamp_to: Option[Long] = Option.empty /** item timestamp: to */
                     )
