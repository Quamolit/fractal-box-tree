
(ns box-tree.comp.container
  (:require [hsl.core :refer [hsl]]
            [quamolit.alias :refer [create-comp group text rect]]
            [box-tree.comp.branch :refer [comp-branch]]
            [quamolit.render.element :refer [translate]]))

(defn render [timestamp store]
  (fn [state mutate! instant tick]
    (comment .log js/console state)
    (translate {:style {:y 300, :x 0}} (comp-branch 10 40 -190))))

(def comp-container (create-comp :container render))
