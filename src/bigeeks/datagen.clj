(ns bigeeks.datagen)

(defn mk-data
	"(list [0 1 2 ... n] [0 1 2 ... n] ...)"
	[cols]
	(let [mk-rand #(int (* (+ (rand) (rand)) %))
	      mk-cols #(map mk-rand (range cols))]
	      (repeatedly mk-cols)))
	     
(defn mk-cols
	[cols]
	(map #(int (* (+ (rand) (rand)) %)) (range cols)))
