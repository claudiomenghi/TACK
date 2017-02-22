(asdf:operate 'asdf:load-op 'ae2zot) (use-package :trio-utils)
(define-tvar z0_16 *real*)
(define-tvar z1_16 *real*)
(defvar trio-spec (&&(&&(&&([=] z0_16 0) (&&(alwf (&&(<-> (||(&&(!! (yesterday (-P- H_16))) (-P- H_16)) (&&(yesterday (-P- H_16)) (!! (-P- H_16)))) (||([=] z0_16 0) ([=] z1_16 0))) (&&(-> ([=] z0_16 0) (next (release ([=] z1_16 0) ([>] z0_16 0)))) (-> ([=] z1_16 0) (next (release ([=] z0_16 0) ([>] z1_16 0))))))) (&&(&&(alwf (||(next ([=] z0_16 0)) (next ([>] z0_16 0)))) (||(alwf (somf ([=] z0_16 0))) (somf (alwf ([>] z0_16 1000))))) (&&(&&(alwf (||(next ([=] z1_16 0)) (next ([>] z1_16 0)))) (||(alwf (somf ([=] z1_16 0))) (somf (alwf ([>] z1_16 1000))))) (&&([>=] z0_16 0) ([>=] z1_16 0)))))) (alwf (&&(<-> (-P- P_16) (&&(-P- P_2) (-P- P_2))) (<-> (-P- H_16) (&&(-P- H_2) (-P- H_2))))))))

(ae2zot:zot 10 trio-spec)