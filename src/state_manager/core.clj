(ns state-manager.core)

(def app-state (atom {}))


(defn update-state
  "Takes a map of a key value and sets the current key in state to the value passed"
  [state]
  (swap! app-state merge state))

(defn state-reset
  "Multi arity, can reset the state to blank, or to a default value passed in"
  []
  (reset! app-state {}))

(defn get-state
  "This should be a multi arity function that when passed a key returns just that or else returns the whole state"
  ([] @app-state)
  ([key] (key @app-state))
  )

(defn set-initial-state
  "Should be used to set initial state, completly swaps out the state"
  [state]
  (swap! app-state merge state))


;examples
;(set-initial-state {:test 5 :test2 10})
;(update-state {:test 5 :test2 2 :test3 40})
; (get-state)
; (get-state :test)
