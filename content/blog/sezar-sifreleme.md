---
Title: Sezar şifreleme
Date: 2007-12-12T05:35:00+03:00
Author: Aşkın Özgür
Category: Programlama
Tags: ["Algoritma", "Scheme", "Sezar"]
Slug: sezar-sifreleme
Status: published
---

Sezar şifreleme için yazdığım ilk kod aşağıdaki gibiydi

```scheme
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
```

Ancak bu kod pek hoşuma gitmedi üzerinde biraz daha oynama yapmak gerekiyordu. Mesela en baştaki

```scheme
(define str2 "")
```

pek hoş durmuyordu ve hiç bir sonuç gönmüyordu. Ekstradan srt2 nin değerini sorgulamak gerekiyordu.  
<!--more-->  
Bu sebeple kodu aşağıdaki hale getirdim.

```scheme
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
```

Ancak yine eksiklikler vardı.

```scheme
(sezar "zeliha" '(1 2))
```

bize "{gmkic" değerini döndürüyordu. "agmkic" gibi bir değer bizim için daha hoş olabilirdi.

```scheme
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
```

Burda eklediğim satırlar karaktere çevirilecek sayının değerinin 122den büyük olup olmadığını kontrol ediyor. Eğer z+1=123 gibi bir değer elde ederse bu değer a'ya çevirliyor.  
Kodlara [Burdan](http://www.askin.ws/doc/sezar.scm) ulaşabilirsiniz.
