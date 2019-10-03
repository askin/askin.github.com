---
Title: Bubble sort  algoritması ve scheme çözümü
Date: 2007-12-17T15:11:00+03:00
Author: askin
Category: Programlama
Tags: ["Algoritma", "Bubble", "Sıralama"]
Slug: bubble-sort-algoritmasi-ve-scheme-cozumu
Status: published
---

Bubble sort algoritması kabaca: verilen dizideki elemanları ikili olarak karşılaştırıp gerekli olduğunda yerlerini değiştirmek esasına dayanır. Elimizde 11 5 8 4 6 84 7 sayılarında oluşan bir dizi olduğunu var sayalım ve bu diziyi küçükten büyüğe sıralamak isteyelim.

1.  önce 11 ile 5i karşılaştırırız, 11 5'ten büyük olduğu için 11 ile 5in yerini değiştiririz; 5 11 8 4 6 84 7
2.  sonra 11 ile 8i karşılaştırırız ve 11 ile 8'in yerini değiştiririz 5 8 11 4 6 84 7
3.  11 ile 4; 5 8 4 11 6 84 7
4.  11 ile 6; 5 8 4 6 11 84 7
5.  11 ile 84; 84 büyük olduğu için sıralamaya dokunmayız. 5 8 4 6 11 84 7
6.  şimdi 84 ile 7'yi karşılaştırırız; 5 8 4 6 11 7 84

Son durumda 7 elemanlı bir dizi için 6 kontrol yaptık ve en büyük elemanı sona attık. Şimdiki karşılaştırmalarımızda artık son elamanı yok sayabiliriz. Yani problemimiz artık 6 elemanlı bir diziyi sıralamak oldu. Aynı işlemleri 6 eleman varsayarak yaptığımızda sırasıyla problem 5, 4, 3, 2 ve 1 elemanlı dizileri sıralamaya dönüşecek. 1 elemanlı dizi herzaman sıralı olduğu için hiç bi derdimiz sıkıntımızda kalmayacak:) Bu şekilde işlemleride 6 defa yaptık.  
Şimdi sıra geldi koda

```scheme
(define vector-bubble-sort 
  (lambda (vec op)
    (let ((tmp 0) (stop-do #f))
      (do ((i 0 (+ i 1))) ((or (= i (vector-length vec)) stop-do))
        (set! stop-do #t)
        (do ((j 0 (+ j 1))) ((= j (- (vector-length vec) i 1)))
          (if (not (op (vector-ref vec j) (vector-ref vec (+ j 1))))
              (begin 
                (set! tmp (vector-ref vec j))
                (vector-set! vec j (vector-ref vec (+ j 1)))
                (vector-set! vec (+ j 1) tmp)
                (set! stop-do #f))))))
    vec))
```

DrScheme de etkileşim penceresine

```scheme
(vector-bubble-sort #(5 11 8 4 6 84 7) < )
```

şeklide giriş yapmamız gerekiyor. "&lt; " işareti yerine "&gt;" işaretide koyabiliriz. Bu sayede birde büyükten küçüğe sıralamak için aynı kodları yazmamıza gerek kalmayacak.
