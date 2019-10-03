---
Title: Linux'ta disk doluluk oranının yanlış hesaplanması
Date: 2013-07-22T15:13:00+03:00
Author: askin
Category: Linux
Tags: ["df", "disk", "du", "free space"]
Slug: linuxta-disk-doluluk-oraninin-yanlis-hesaplanmasi
Status: published
---

![disk](/uploads/2013/07/disk.png)Bir sunucuda garip bir problemle karşılaştım, diskte yer kalmadığını söylüyordu fakat ne yaparsam yapayım diski dolduran dosyaları bulamıyordum. Biraz araştırınca sorunu ve çözümünü buldum. Senaryo şöyle idi:

1.  Dosya bir program tarafından okumak için açılır.
2.  Başka bir program bu dosyayı siler.

Bu senaryo gerçekleştiğinde, her ne kadar dosya silinmiş olsa da, hala diskte yer tutmaya devam edecektir. "du" komutuyla baktığınızda yer tutmayacaktır, ancak df ile kontrol ettiğimizde disk dolu olarak görünecektir.

Basit bir demo yapacağım:

Öncelikle 1GB boyutunda bir dosya oluşturacağım.

```bash
mkdir /tmp/tmp_directory/
cd /tmp/tmp_directory/
dd if=/dev/zero of=1gb_file.dat bs=1M count=1024
```

Oluşturulan bu dosyayı python ile açacağım.

```python
python
Python 2.7.4 (default, Jul  5 2013, 08:21:57)
[GCC 4.7.3] on linux2
Type "help", "copyright", "credits" or "license" for more information.
>>> f = open("1gb_file.dat", "rwb")
>>>
```

Şimdi disk bilgilerine bakıyorum

```bash
df -h
Filesystem      Size  Used Avail Use% Mounted on
/dev/sda5       414G   11G  382G   3% /
```

Görüldüğü gibi diskin 11GB'lık kısmı kullanılıyor.

```bash
du -sh tmp_directory/
1.1G    tmp_directory/
```

tmp\_directory dizini diskte 1.1GB yer tutuyor.

Şimdi dosyayı siliyorum.

```bash
rm tmp_directory/1gb_file.dat
```

Disk bilgilerini tekrar kontrol edelim:

```bash
df -h
Filesystem      Size  Used Avail Use% Mounted on
/dev/sda5       414G   11G  382G   3% /

du -sh tmp_directory/
4.0K    tmp_directory/
```

Görüldüğü gibi, df çıktısı hala diski 11GB dolu görüyor, du ile baktığımızda ilgili dizinin boyu sadece 4KB, buda boş bir dizinin diskte tuttuğu yer.

Açtığımız dosyayı geri kapatalım.

```python
>>> f.close()
```

Tekrar kontrollerimizi yapalım:

```bash
df -h
Filesystem      Size  Used Avail Use% Mounted on
/dev/sda5       414G   10G  383G   3% /
```

Dosya kapatıldıktan sonra 1.1GB'lık alan tekrar boş olarak hesaplandı.

Bu dosyayı biz oluşturduğumuz için hangi dosya üzerinde işlem yapacağımızı biliyorduk, peki bu durumda olan dosyalarını nasıl bulabiliriz?

lsof komutu yardımıyla bunu yapabiliriz.

```bash
sudo lsof | grep deleted
python    21882            askin    3r      REG                8,5         0    7211180 /tmp/tmp_directory/1gb_file.dat (deleted)
```

Bu şekilde hangi açık dosyaların silinmiş olduğunu görebiliriz. Bu çıktıya göre, askin kullanıcısı 21882 process id'si ile python programıyla /tmp/tmp\_directory/1gb\_file.dat dosyasını açmış, fakat bu dosya hala açıkken silinmiş. Bu dosyayı kapatmak için biraz daha bilgiye ihtiyacımız var.

```bash
sudo ls -l /proc/21882/fd/*
lrwx------ 1 askin askin 64 Jul 22 14:58 /proc/21882/fd/0 -> /dev/pts/11
lrwx------ 1 askin askin 64 Jul 22 14:58 /proc/21882/fd/1 -> /dev/pts/11
lrwx------ 1 askin askin 64 Jul 22 14:58 /proc/21882/fd/2 -> /dev/pts/11
lr-x------ 1 askin askin 64 Jul 22 14:58 /proc/21882/fd/3 -> /tmp/tmp_directory/1gb_file.dat (deleted)
```

Burdan aldığımız bilgiyle dosyamızı kapatabiliriz.

```bash
sudo cat /dev/null > /proc/21882/fd/3
```
