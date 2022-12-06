#! /usr/bin/env racket
#lang racket
(define input (file->string "input.txt" ))

(define in? (lambda (str cha)
    (cond 
        [(empty? str) #f]
        [(char=? (first cha) (first str)) #t]
        [else (in? (substring str 1) cha)]
    )
    )
)

(define allUnique? (lambda (text)
    #t
    )
)

(define checkFront (lambda (text bigIndex)
    (define subs (substring text 0 5))
    (if (allUnique? subs) bigIndex (checkFront (substring text 1) (+ bigIndex 1)))
)
)
(in? "hello" "l")
(checkFront input 5)