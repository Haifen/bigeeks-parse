(ns bigeeks.datagen
	(:require [clojure.core :as c]
		  [clojure.contrib.seq :as s]
		  [clojure.contrib.io :as io]
		  [clojure.contrib.string :as string]
		  [clj-http.client :as http]))

(defn mk-data
	"(list [0 1 2 ... n] [0 1 2 ... n] ...)"
	[cols]
	(let [mk-rand #(int (* (+ (rand) (rand)) %))
	      mk-cols #(map mk-rand (range cols))]
	      (repeatedly mk-cols)))

(defn dumptofile
	[filename rows cols]
	(io/write-lines filename (map #(string/join ", " %) (take rows (mk-data cols)))))

(defn dumptofile2
	[filename rows cols]
	(loop [myline (take rows (mk-data cols))]
		(when (first myline)
			(println (string/join ", " (first myline)))
		(recur (next myline)))))
			
