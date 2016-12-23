
(ns box-tree.updater.core (:require [box-tree.schema :as schema]))

(defn updater-fn [store op op-data tick]
  (comment .log js/console "store update:" op op-data tick)
  (case op :move (merge store op-data) store))
