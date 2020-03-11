---
Title: Python Sözlük Hızlı Rehber
Date: 2013-07-20T15:32:00+03:00
Author: Aşkın Özgür
Category: Programlama
Tags: ["dictionary", "python"]
Slug: python-sozluk-hizli-rehber
Status: published
---

Başlığında söylediği gibi, Python sözlük hızlı rehber

```python
# Anahtar/değer çiftleriyle sözlük tanımlama
dict = {
    'anahtar1′ : 'deger1′,
    'anahtar2′ : 'deger2′,
    'anahtar3′ : 'deger3′
}

# Tüm anahtarları al
sozluk.keys()

# Tüm değerleri al
sozluk.values()

# Düzenleme
sozluk['anahtar2'] = 'deger8′

# Erişim
print sozluk['anahtar1']

# 'deger2'yi yazdır
print sozluk['anahtar2']

# Boş sözlük tanımlama ve değer atama
bosSozluk = {}
bosSozluk['anahtar4'] = 'deger4'

# Sözlük üzerinde döngü kurma (foreach)
for anahtar in sozluk:
    print sozluk[anahtar]

# Anahtarları sıralayıp, o sıraya göre değerleri yazdırmak
anahtarlar = sozluk.keys()
anahtarlar.sort()
for anahtar in anahtarlar:
    print sozluk[anahtar]

# Değerlere göre döngü kurmak (sıralı değil)
for deger in sozluk.values():
    print deger

# Tek seferde anahtar ve değer çiftlerini al
for anahtar, deger in sozluk.items():
    print "%s=%s" % (anahtar, deger)

# Kayıt silme
del sozluk['anahtar2']

# Tüm kayıtları silmek
sozluk.clear()

# Boyut
len(sozluk)
```
