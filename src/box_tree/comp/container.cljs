
(ns box-tree.comp.container
  (:require [hsl.core :refer [hsl]]
            [quamolit.alias :refer [create-comp group text rect]]
            [box-tree.comp.branch :refer [comp-branch]]))

(defn render [timestamp store]
  (fn [state mutate! instant tick]
    (comment .log js/console state)
    (group {:style {}} (comp-branch))))

(def comp-container (create-comp :container render))
