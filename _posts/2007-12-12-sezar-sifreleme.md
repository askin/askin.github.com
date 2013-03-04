---
layout: post
title: "Sezar şifreleme"
published: true
tags:
- Algoritma
- Programlama
- Scheme
- Sezar
- Şifreleme
type: post
status: publish
---
Sezar şifreleme için yazdığım ilk kod aşağıdaki gibiydi

    (define str2 "")
    (define (sezar str lst)
      (do ((i 0 (+ i 1)) (j 0 (+ j 1))) ((= j (string-length str)))
        (if (= i (length lst))
            (set! i 0))
        (set! str2
              (string-append
               str2
               (string (integer->char
                        (+ (list-ref lst i )
                           (char->integer (string-ref str j)))))))))

Ancak bu kod pek hoşuma gitmedi üzerinde biraz daha oynama yapmak gerekiyordu. Mesela en baştaki

    (define str2 "")

pek hoş durmuyordu ve hiç bir sonuç gönmüyordu. Ekstradan srt2 nin değerini sorgulamak gerekiyordu.

Bu sebeple kodu aşağıdaki hale getirdim.

    (define (sezar str lst)
      (let ((str (string-downcase str)) (str2 ""))
      (do ((i 0 (+ i 1)) (j 0 (+ j 1))) ((= j (string-length str)))
        (if (= i (length lst))
            (set! i 0))
        (set! str2
              (string-append
               str2
               (string (integer->char
                        (+ (list-ref lst i )
                           (char->integer (string-ref str j))))))))
        (values str2)))


Ancak yine eksiklikler vardı.

    (sezar "zeliha" '(1 2))

bize "{gmkic" değerini döndürüyordu. "agmkic" gibi bir değer bizim için daha hoş olabilirdi.

    (define (sezar str lst)
      (let ((str (string-downcase str)) (str2 "") (tmp 0))
      (do ((i 0 (+ i 1)) (j 0 (+ j 1))) ((= j (string-length str)))
        (if (= i (length lst))
            (set! i 0))
        (set! str2
              (string-append
               str2
               (string (integer->char
                        (begin
                          (set! tmp (+ (list-ref lst i )
                           (char->integer (string-ref str j))))
                          (cond
                            [(> tmp 122) (- tmp 26)]
                            [else tmp])))))))
        (values str2)))

Burda eklediğim satırlar karaktere çevirilecek sayının değerinin 122den büyük olup olmadığını kontrol ediyor. Eğer z+1=123 gibi bir değer elde ederse bu değer a'ya çevirliyor.
Kodlara [Burdan][1] ulaşabilirsiniz.
[1]: http://www.askin.ws/doc/sezar.scm
