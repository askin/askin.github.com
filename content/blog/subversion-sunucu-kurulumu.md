---
Title: Subversion sunucu kurulumu
Date: 2012-08-23T18:16:00+03:00
Author: Aşkın Özgür
Category: Linux
Tags: ["Linux", "server", "subversion", "sunucu"]
Slug: subversion-sunucu-kurulumu
Status: published
---

Linux üzerinde kurulumdan bahsedeceğim. Öncelikle kullandığınız dağıtımın paket deposundan subversion paketini kurmalısınız. Ben debian kullandığım için

```bash
sudo apt-get install subversion
```

Kurulum tamamlandıktan sonra gerekli tüm araçlara sahip olmuş oluyoruz.

Bir depo oluşturalım.

```bash
svnadmin create depom
```

depom adli dizinde bir depo oluşturmuş olduk. Bu depo üzerinde gerekli düzenlemeleri yapalım.  
*depom/conf/svnserve.conf* bu dosya temel ayarlarimizi yapacağımız dosya. Bu dosyayı açıp \[general\] başlığı altındaki ayarları düzenliyoruz. Burdaki tüm ayarlar yorum satırı haline getirişmiş, bunlardan işimize yarayanları aktif hale getirmemiz gerekiyor.

    # anon-access = read

Tanımladığımız kullanıcılar dışında kalan kişilerin yetkilerini düzenlemek için kullanıyoruz. Eğer yorum satırı halinde bırakırsak tanımsız kullanıcılar depo üzerinde okuma hakkına sahip oluyorlar. Eğer bu şekilde bırakırsak okuma yapamazlar. Eğer read yerine write yazarsak depomuzda herkes okur-yazar oluyor.

    # auth-access = write

Kayıtlı kullanıcıların yetkilerini burdan belirliyoruz. Yorum satırı olmaktan çıkartırsak depomuzda tanımlı kullanıcılar yazma hakkına sahip olur.

    # password-db = passwd

Depoya erişim yetkisi verdiğimiz kullanıcıların kullanıcı adı ve parolaların tutulduğu yeri belirtir. Kullanıcıları tanımlamak için yorum satırı halinden çıkartıp istediğimiz yolu belirtmeliyiz, daha sonra ilgili dosyayı düzenlemeliyiz.  
Dosya içeriği

    [users]
    askin = parolam

Parolalar şifrelenmemiş halde tutuluyor.

    # authz-db = authz

Kullanıcıların izinlerini daha detaylı olarak ayarlamak istersek bu satırı yorum satırı halinden çıkartıp, istediğimiz bir yolu girmemiz gerekmekte.

    # realm = My First Repository

Depomuzun adı, bu satırı yorum satırı olmaktan çıkartıp istediğimiz bir isim veriyoruz.

Tüm bunları yaptıktan sonra depomuzu yayınlayabiliriz. Bunu yapmak için *svnserve* adında bir programdan yararlanıyoruz.

```bash
/usr/bin/svnserve -d -r /home/svn/repositories --log-file /var/log/svnserve
```

Bu komut */home/svn/repositories* dizinindeki tüm depoları yayınlar.

Depoyu chekout etmek için

```bash
svn checkout svn://sunucu.com/depom
```

<!--more-->
