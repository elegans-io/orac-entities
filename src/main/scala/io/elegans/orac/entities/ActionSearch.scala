package io.elegans.orac.entities

/**
  * Created by Angelo Leto <angelo.leto@elegans.io> on 27/03/18.
  */

case class ActionSearch (
                          name: Option[String] = Option.empty, /** the name of an action */
                          creator_uid: Option[String] = Option.empty, /** system user id who has written the action, generated on insert */
                          user_id: Option[String] = Option.empty, /** user id of the action */
                          item_id: Option[String] = Option.empty, /** user id of the action */
                          timestamp_from: Option[Long] = Option.empty, /** action timestamp: from */
                          timestamp_to: Option[Long] = Option.empty, /** action timestamp: to */
                          score_from: Option[Double] = Option.empty, /** score for the action */
                          score_to: Option[Double] = Option.empty, /** score for the action */
                          ref_url: Option[String] = Option.empty, /** referring url if any */
                          ref_recommendation: Option[String] = Option.empty /** referring recommedation if any */
                        )
