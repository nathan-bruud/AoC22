#! /usr/bin/env racket
#lang racket
(define input (file->string "input.txt" ))


(define (all-chars-unique? str)
  (define chars (set->list (list->set (string->list str))))
  (= (string-length str) (length chars)))

(all-chars-unique? "hello")

(define checkFront (lambda (text bigIndex)
    (define subs (substring text 0 14))
    (if (all-chars-unique? subs) bigIndex (checkFront (substring text 1) (+ bigIndex 1)))
)
)
(checkFront input 14)