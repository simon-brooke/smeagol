(ns smeagol.test.local-links
  (:require [clojure.test :refer :all]
            [smeagol.local-links :refer [local-links no-text-error]]
            [smeagol.extensions.test :refer :all]
            [smeagol.local-links :refer :all]))

(deftest test-local-links
  (testing "Rewriting of local links"
    (is (= (local-links nil) no-text-error) "Should NOT fail with a no pointer exception!")
    (is (= (local-links "") "") "Empty string should pass through unchanged.")
    (is (= (local-links "[[froboz]]") "<a href='wiki?page=froboz'>froboz</a>") "Local link should be rewritten.")
    (let [text (str "# This is a heading"
                             "[This is a foreign link](http://to.somewhere)")]
      (is (= (local-links text) text) "Foreign links should be unchanged"))))
