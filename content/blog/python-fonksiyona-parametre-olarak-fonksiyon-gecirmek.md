---
Title: Python, Fonksiyona Parametre Olarak Fonksiyon Geçirmek
Date: 2010-05-01T03:51:00+03:00
Author: Aşkın Özgür
Category: Programlama
Tags: ["fonksiyon", "parametre", "Programlama"]
Slug: python-fonksiyona-parametre-olarak-fonksiyon-gecirmek
Status: published
---

Bu yazıyı asıl yazma sebebim parametre olarak geçirilen fonksiyona geçirilecek parametreler :)  
Parametre olarak geçireceğimiz fonksiyonlar belli bir sayıda parametre alıyorsa yapacağımız iş basit,

Mesela:

```python
def Merhaba(isim):
    print "Merhaba %s" % isim
```

Bunun gibi sadece tek parametre alan bir fonksiyon için aşağıdaki gibi bir fonksiyon yeterli olacaktır.

```python
def BuyukAbi(func, param):
    func(param)
```

```python
BuyukAbi(Merhaba, "kelebek")
Merhaba kelebek
```

Bu fonksiyon parametre olarak aldığı func fonksiyonuna param parametresini geçirecektir.  
Eğer fonksiyonun aldığı parametre sayısı belirsiz ise, yani farklı sayıda parametre alan fonksiyonlarla uğraşmak gerekiyorsa yanına birkaç ekleme daha yapmamız gerekiyor.

```python
def BuyukBuyukAbi(func, param):
    func(*param)
```

param parametresi bir liste olmak durumunda. Geçirilen fonksiyon kaç parametre alıyorsa listenin uzunluğu okadar olmalı.

```python
BuyukBuyukAbi(Merhaba, ["kelebek"])
Merhaba kelebek
```

```python
def HepinizeMerhaba(isim1, isim2):
    print "Merhaba %s, merhaba %s" % (isim1, isim2)
```

```python
BuyukBuyukAbi(HerpinizeMerhaba, ["kelebek", "Aşkın"])
Merhaba kelebek, merhaba Aşkın
```
<!--more-->
