
(ns box-tree.comp.branch
  (:require [hsl.core :refer [hsl]]
            [quamolit.alias :refer [create-comp group text rect]]
            [quamolit.render.element :refer [translate scale rotate]]))

(def style-box {:w 200, :h 200, :fill-style (hsl 240 80 80)})

(defn render []
  (fn [state mutate! instant tick]
    (rect
     {:style style-box}
     (translate
      {:style {:y -160, :x -140}}
      (scale {:style {:ratio 0.8}} (rotate {:style {:angle 30}} (rect {:style style-box})))))))

(def comp-branch (create-comp :branch render))
