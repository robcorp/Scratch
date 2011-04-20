(ns scratch.core
  (:import (org.joda.time DateTime)
	   (com.thoughtworks.xstream XStream)
	   (com.thoughtworks.xstream.converters.basic AbstractSingleValueConverter)
	   (com.thoughtworks.xstream.converters.extended ToStringConverter)
	   (com.thoughtworks.xstream.io.json JsonHierarchicalStreamDriver)
	   ))

(def DateTimeConverter (proxy [AbstractSingleValueConverter] [] 
			 (canConvert [c] (= c DateTime))
			 (fromString [s] (DateTime. s))))

(defrecord Person [fname lname dob address])
(defrecord Address [line1 line2 line3 city state zip country])

(def *me* (Person. "Rob" "Houser"
		   (DateTime. 1968 8 21 12 0 0 0)
		   (Address. "1335 Roberts Road" "" "" "Gilbertsville" "PA" 19525 "USA")))

(def xstream (doto (XStream.)
	       (.alias "person" scratch.core.Person)
	       (.alias "address" scratch.core.Address)
	       (.registerConverter DateTimeConverter)
					;(.registerConverter (ToStringConverter. DateTime))
					; note: this doesn't work because DateTime doesn't
					;have a String constructor
	       ))


;(println (.toXML xstream *me*))

