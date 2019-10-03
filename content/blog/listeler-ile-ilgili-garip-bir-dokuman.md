---
Title: Listeler ile ilgili garip bir döküman
Date: 2013-07-13T15:50:00+03:00
Author: askin
Category: Programlama
Tags: ["list"]
Slug: listeler-ile-ilgili-garip-bir-dokuman
Status: published
---

  

> Bu yazı oluşturulurken <http://www.pythonforbeginners.com/python-lists-cheat-sheet/> adresindeki yazı referans alınmıştır. Bir çok yeri doğrudan çeviri olmakla beraber bir kısmını kendim baştan yazdım. Yazım - Mantık hataları vs. bulursanız yorum yazmaktan çekinmeyin.

Liste Nedir?
------------

> Bir veya birden fazla elemanı tutmak için kullanılan en basit veri yapısıdır. Liste elemanlar topluluğudur (string, integer ve hatta diğer listeler). Listedeki her bir elemana index değeri atanır.  
> Listeler köşeli parantezler ile açılıp kapatılır. Listedeki her bir eleman virgül ile ayrılır. Stringlerin aksine listeler mutable - değişkendir, bunun manası listeler değiştirilebilir.

Liste Yaratma
-------------

> Listeler köşeli parantez ile açılıp kapatılan, virgülle ayrılmış elamanlarla yaratılır.  
> Listeler bir takım değerler tutar (aynı stringlerin karakter serileri barındırması gibi).  
> Listeler çok kolay yaratılır, aşağıda liste oluşturmanın birkaç yolu vardır

```python
emptyList = [ ]  

list1 = ['one, two, three, four, five']
 
numlist = [1, 3, 5, 7, 9]
 
mixlist = ['yellow', 'red', 'blue', 'green', 'black']
 
# Boş bir liste adece köşeli parantez kullanılarak oluşturulur:
list = []
```

Liste Boyu
----------

> len fonksiyonunu kullanarak listenin boyunu alabiliriz.

```python
list = ["1", "hello", 2, "world"]
len(list)
>>> 4
```

List Append (Ekleme)
--------------------

> Append listenin sonuna eleman ekleyecektir. Eğer listenin başına ekleme yapmak istiyorsanız insert fonksiyonunu kullanabilirsiniz.  
> list.insert(0, "Files")

```python
list = ["Movies", "Music", "Pictures"]
  
# list.append(x) listenin sonuna bir eleman ekleyecektir
list.append("Files")
 
print list
>>> ['Movies', 'Music', 'Pictures', 'Files']
```

List Insert (Araya ekleme)
--------------------------

> Syntax: list.insert(x, y) \# y elemanını x. elemanın önüne yerleştirecektir

```python
list = ["Movies", "Music", "Pictures"] 
 
list.insert(2,"Documents")
 
print list
['Movies', 'Music', 'Documents', 'Pictures', 'Files']
 
# Listede istediğiniz bir yere eleman ekleyebilirsiniz
 
list = ["Movies", "Music", "Pictures"] 
list.insert(3, "Apps")
```

List Remove (eleman çıkartma)
-----------------------------

> Listeden bir elemanı çıkartmak için remove metodu kullanılır. Eğer eleman listede birden fazla tekrar ediyorsa, sadece ilk eleman çıkartılır, diğerleri kalır.
>
> Syntax: list.remove(x)

```python
List = ['Movies', 'Music', 'Files', 'Documents', 'Pictures']
 
list.remove("Files")
 
print list
['Movies', 'Music', 'Documents', 'Pictures']
 
a = [1, 2, 3, 4]
a.remove(2)
print a
>>> [1, 3, 4]
```

List Extend (Liste genişletme)
------------------------------

> Listeleri birleştirmek istediğimz zaman extend metodunu kullanabiliriz.  
> Syntax: list.extend(x) \# x listesinin elamanlarını listeye ekleyecektir

```python
list2 = ["Music2", "Movies2"]
list1.extend(list2)
 
print list1
>>> ['Movies', 'Music', 'Documents', 'Pictures', 'Music2', 'Movies2']
```

List Del (Listeden silme)
-------------------------

> Belli bir indexteki elemanı çıkartmak için del fonksiyonunu kullanırız.

```python
list = ["Matthew", "Mark", "Luke", "John"]
del list[1]
 
print list
>>> ["Matthew", "Luke", "John"]
```

List Keywords
-------------

> "in" terimi bir elemanın listede olup olmadığını kontrol etmek için kullanılabilir.

```python
list = ["red", "orange", "green", "blue"]
if "red" in list:
    do_something()
     
# "not" terimi "in" ile birlikte kullanılabilir
 
list = ["red", "orange", "green", "blue"]
if "purple" not in list:
    do_something()
```

List Reverse (Liste tersi)
--------------------------

> Reverse metodu tüm listenin sıralamasını tersine çevirecektir.

```python
L1 = ["One", "two", "three", "four", "five"]
  
# Listeyi olduğu gibi yazdır
print L1
>>> ["One", "two", "three", "four", "five"]

# Listeyi tersten yazdır
for i in L1[::-1]:
    print i
 
# YADA
 
L = [0, 10, 20, 40]
L.reverse()
 
print L
>>> [40, 20, 10, 0]
```

List Sorting (Sıralama)
-----------------------

> Bir listeyi sıralamanın en kolay yolu sorted fonksiyonunu kullanmaktır.  
> Bu fonksiyon parametre olarak bir fonksiyon alır ve sıralanmış olarak yeni bir liste döndürür. Asıl liste değişikliğe uğramaz.
>
> sorted() fonksiyonu opsiyonel parametrelerle özelleştirilebilir. "reverse=True" parametresi listeyi tersten sıralanmış olarak döndürecektir. sorted(list, reverse=True)

```python
# içinde bazı numaralar olan bir liste oluştur
numbers = [5, 1, 4, 3, 2, 6, 7, 9]
  
# numaraları sıralı olarak yazdır
print sorted(numbers)
  
# asıl listenin elemanları bir değişikliğe uğramadı
print numbers
my_string = ['aa', 'BB', 'zz', 'CC', 'dd', "EE"]
 
# Eğer hiç bir parametre kullanılmazsa ön tanımlı değerler kullanılacaktır (Büyük - Küçük duyarlı)
print sorted(my_string)
 
# reverse parametresi ile tersten sıralayacaktır
print sorted(strs, reverse=True)   # ['zz', 'aa', 'CC', 'BB']

# Bu bir sonuç döndürmeyecektir, listeyi değiştirecektir
list.sort()
```

List Split (Dilimleme)
----------------------

> Bir stringi dilimleyip liste haline getirebiliriz. Bunu yapmak için split metodunu kullanırız. Eğer metoda parametre geçirmezsek boşluk karakterine göre dilimleyecektir.

```python
list = 'one, two, three, four, five'
newlist = list.split(',')
 
print newlist
>>> ['one', ' two', ' three', ' four', 'five']
```

List Indexing
-------------

> Listedeki her bir elamana 0dan başlayacak şekilde bir numara atanır. Bu numaraya index adı verilir. Bu index kullanılarak listenin elemanına doğrudan erişebiliriz.

```python
list    = ["first", "second", "third"]
list[0] == "first"
list[1] == "second"
list[2] == "third"
```

List Slicing
------------

> Bazen listenin bir kısmına ulaşmak isteyebiliriz. Python bunu dahali olarak destekler. Bir listenin elemanına ulaşmaya çalışır gibi, başlangıç ve bitiş indexleri vererek belirli bir aralıktaki değerleri liste olarak alabiliriz.

```python
colors = ['yellow', 'red', 'blue', 'green', 'black']
 
print colors[0]
>>> yellow
     
print colors [1:]
>>> red, blue, green, black
```

[Bu](http://stackoverflow.com/questions/509211/the-python-slice-notation) stackoverflow sayfasından alınan örneğe bakalım.

```python
# baslangictan, son indexine kadar (son dahil değil)
a[baslangic:son]
# baslangic indexinden listenin sonuna kadar
a[baslangic:]
# listenin basindan, son indexine kadar (son dahil değil)
a[:son]
# tüm listenin kopyası
a[:]
```

Birde kullanabileceğimiz adım sayısı vardır.

```python
# belirli adimlara göre
a[start:end:step]
```

FIXME: hem anlatım bozukluğuna bak, hemde test et  
Bir diğer özellik de başlangıç ve bitiş değerleri negatif sayı olabilir, bu durumda listenin başından değilde sonundan itibaren saymamız gerekir.

```python
# listedeki son eleman
a[-1]
# listenin son iki elemanı
a[-2:]
# son iki eleman hariç listenin tüm elemanları
a[:-2]
```

List Loops
----------

> Bazen bir liste üzerindeki elemanları kullanacak bir döngü kurmak isteriz. Pythonda bunu "in" terimi kullanarak rahatlıkla yapabiliriz.

```python
# Buna benzeyebilir
matching = []
for term in mylist:
    do something
 
# Bir koşulu saylayan liste elemanlarını başka bir listeye atmak
matching = []    # Boş bir liste oluştur
for term in mylist:
    if test(term):
        matching.append(term)
 
# İçinde eleman olan bir listeyi bu şekilde döngüye sokabiliriz
items = [ 1, 2, 3, 4, 5 ]
for i in items:
    print i
```

List Methods
------------

> Calls to list methods have the list they operate on appear before the method name.
>
> Any other values the method needs to do its job is provided in the normal way as  
> an extra argument inside the round brackets.

    s = ['h','e','l','l','o']  # liste oluştur
    s.append('d')               # listenin sonuna ekle
    len(s)                      # listedeki eleman sayısı
    s.sort()                    # listeyi sırala
    s.reverse()                 # listeyi ters çevir
    s.extend(['w','o'])         # listeyi genişlet
    s.insert(1,2)               # araya eleman ekle
    s.remove('d')               # listedeki ilk 'd' elemanını çıkart
    s.pop()                     # listedeki son elemanı çıkart
    s.pop(1)                    # 1 nolu indexteki elemanı çıkart
    s.count('o')                # listede bulunan 'o' ların sayısı
    s = range(0,10)             # 0 - 10 aralığındaki sayılardan oluşan bir liste oluştur
    s = range(0,10,2)           # yukardaki benzeri fakat bir de adım değeri belirle

Örnekler
--------

> Bu makaleyi bazı liste örnekleri göstererek bitirelim.

İlk olarak sadece sayılardan oluşan bir liste oluşturalım.

```python
list = [1,2,3,5,8,2,5.2]    # 1,2,3,5,8,2,5.2 değerlerini tutan bir liste oluştur
i = 0
while i < len(list):     # Listenin her bir elemanını yazdıran while döngüsüin the list
    print list[i]        # Her elemana index değeriyle ulaşılıyor
    i = i + 1            # While döngüsü her çalıştığında i değişkenini 1 arttır
```

Bir sonraki örnek listedeki elemanların ortalama değerini hesaplama.

```python
list = [1,2,3,5,8,2,5.2]
total = 0
i = 0
while i < len(list):
    total = total + list[i]
    i = i + 1
 
average = total / len(list)
print average
```
