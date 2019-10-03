---
Title: Çıkmaz Demeyin Şansınızı Deneyin
Date: 2008-01-22T17:29:00+03:00
Author: askin
Category: Programlama
Tags: ["Piyango"]
Slug: cikmaz-demeyin-sansinizi-deneyin
Status: published
---

Bu girdi [Burdaki](http://tutkudalmaz.org/gunluk/?p=21) girdiden esinlenilerek yazıldı.

E madem pyton ile sayısal kuponu yapılıyor biz niye scheme ile yapmayalım bunu demi:)  
Probleme göre kod bana çok uzun geldi. Belki ilerde optimize edebilirim. Ama şimdilik böyle oynayalım demi:)

```scheme
(define (sayisal)
  (display "Oynamak istediginiz kolan sayisini giriniz: \n")
  (let ((kolon (read)))
    (do ((i 1 (+ i 1))) ((> i kolon))
      (let loop ((lst (list (+ (random 49) 1))) 
                   (sayi (+ 1 (random 49))))
        (if (= (length lst) 6)
            (printf "~a. kolon: ~a\n" i (sort lst < ))
            (if (member sayi lst)
                (loop lst (+ (random 49) 1))
                (loop (append lst (list sayi)) 
                       (+ (random 49) 1))))))))
(sayisal);burası kodun çalıştırılması için. 
;aslında define kısmı çıkartılarak buna gerek kalmamayabilir
;ama  ilerde belki başka birşey içinde kullanırım:)
```
