
(ns box-tree.comp.branch
  (:require [hsl.core :refer [hsl]]
            [quamolit.alias :refer [create-comp group text rect]]
            [quamolit.render.element :refer [translate scale rotate]]))

(declare comp-branch)

(declare render)

(def r 100)

(defn compute-ratio [x y]
  (/ (js/Math.sqrt (+ (js/Math.pow (+ y r) 2) (js/Math.pow (+ x r) 2))) 2 r))

(defn compute-angle [x y]
  (- 0 90 (* 180 (/ (js/Math.atan (/ (+ r x) (+ y r))) js/Math.PI))))

(def style-box {:w (* 2 r), :h (* 2 r), :fill-style (hsl 240 80 80)})

(defn compute-ratio-2 [x y]
  (/ (js/Math.sqrt (+ (js/Math.pow (- x r) 2) (js/Math.pow (+ y r) 2))) 2 r))

(defn compute-position-2 [x y] {:y (- (/ (+ x y) 2) r), :x (+ (/ (- x y) 2))})

(defn compute-angle-2 [x y] (* 180 (/ (js/Math.atan (/ (+ y r) (- x r))) js/Math.PI)))

(defn compute-position [x y] {:y (- (/ (- y x) 2) r), :x (/ (+ x y) 2)})

(defn render [n x y]
  (fn [state mutate! instant tick]
    (rect
     {:style style-box}
     (translate
      {:style (compute-position x y)}
      (scale
       {:style {:ratio (compute-ratio x y)}}
       (rotate
        {:style {:angle (compute-angle x y)}}
        (if (pos? n) (comp-branch (dec n) x y)))))
     (translate
      {:style (compute-position-2 x y)}
      (scale
       {:style {:ratio (compute-ratio-2 x y)}}
       (rotate
        {:style {:angle (compute-angle-2 x y)}}
        (if (pos? n) (comp-branch (dec n) x y))))))))

(def comp-branch (create-comp :branch render))
