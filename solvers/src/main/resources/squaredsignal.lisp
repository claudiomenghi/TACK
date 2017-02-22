(asdf:operate 'asdf:load-op 'ae2zot) (use-package :trio-utils)
(define-tvar z0_1 *real*)
(define-tvar z1_1 *real*)
(defvar trio-spec (&&(&&(&&([=] z0_1 0) (&&(alwf (&&(<-> (||(&&(!! (yesterday (-P- H_1))) (-P- H_1)) (&&(yesterday (-P- H_1)) (!! (-P- H_1)))) (||([=] z0_1 0) ([=] z1_1 0))) (&&(-> ([=] z0_1 0) (next (release ([=] z1_1 0) ([>] z0_1 0)))) (-> ([=] z1_1 0) (next (release ([=] z0_1 0) ([>] z1_1 0))))))) (&&(&&(alwf (||(next ([=] z0_1 0)) (next ([>] z0_1 0)))) (||(alwf (somf ([=] z0_1 0))) (somf (alwf ([>] z0_1 1000))))) (&&(&&(alwf (||(next ([=] z1_1 0)) (next ([>] z1_1 0)))) (||(alwf (somf ([=] z1_1 0))) (somf (alwf ([>] z1_1 1000))))) (&&([>=] z0_1 0) ([>=] z1_1 0)))))) (alwf (&&(<-> (-P- P_1) (&&(-P- P_4) (-P- P_4))) (<-> (-P- H_1) (&&(-P- H_4) (-P- H_4))))))))

(ae2zot:zot 10 trio-spec)