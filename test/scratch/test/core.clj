(ns scratch.test.core
  (:use [scratch.core] :reload)
  (:use [clojure.test]))

(deftest replace-me
  ;; FIXME: write
  (is false "No tests have been written."))

(deftest test-me
  (are [expected actual] (= expected actual)
       scratch.core.Person (class *me*)
       "Rob" (.fname *me*)
       "Houser" (.lname *me*)))
