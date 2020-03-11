---
Title: SSH Filesystem ile uzak makinadaki dizini yerele bağlamak
Date: 2008-05-07T10:36:00+03:00
Author: Aşkın Özgür
Category: Linux
Tags: ["linux", "mount", "ssh"]
Slug: ssh-filesystem-ile-uzak-makinadaki-dizini-yerele-baglamak
Status: published
---

Eğer linux kullanıyorsanız ve herhangi bir uzak makinaya ssh erişimi hakkınız varsa, ssh protokolü kullanarak uzak makinanın herhangi bir dizinini sanki kendi harddiskinizdeymiş gibi kullanabilirsiniz.
Ben daha önce bahsettiğim [internet canavarı:)](http://blog.yollu.com/2008/02/21/telekom-artik-kork-benden/) için bu sistemi kullanıyorum. Ekran kartı pek iyi olmadığı için film izlerken sorun çıkartıyordu(özellikle alt yazılı filmlerde senkron sorunu oluyordu). Ve film arşivim o makinada olduğu için her seferde http protokolü üzerinden filmi kendi makinama çekip izlemek zor geliyordu.
Kullanacağımız programın adı sshfs yani SSH Filesystem.
Kurulum:

 - Debian && Ubuntu && vb.
 ```bash
 aptitude install sshfs
 ```
 - Kaynak koddan derleme
 ```bash
 ./configure
 make
 make install # root yetkileriyle
 ```

 - Kullanımı - Uzak makinadaki bir dizini bağlamak
   ```bash
   sshfs hostname:dizin bağlamanoktası (root yetkileriyle)
   ```
 - Umount - Bağı koparma
   ```bash
   umount bağlamanoktası
   # ya da
   fusermount -u bağlamanoktası
   ```

Bu şekide kullanırsanız bağladığınız dizine ancak root yetkileriyle ulaşabilirsiniz. Her kullanıcının tüm haklarla(hangi kullanıcı ile ssh bağlantısı gerçekleştirdiyseniz onun haklarına sahip oluyosunuz) bağladığınız dizini kulanabilmesini istiyorsanız
```bash
sshfs -o allow_other hostname:dizin bağlamanoktası
```
**Parametreler**
-o parametresini kullanarak uid ve gid değerlerini ayarlayabilirsiniz.

```bash
-o idmap=user
-o uid=<uid>
-o gid=<gid>
-o ro # read only - salt okunur mod
```

**fstab dosyasını kullanarak mount etme**
```
sshfs#USERNAME@REMOTE_HOST:REMOTE_PATH MOUNT_POINT fuse SSHFS_OPTIONS 0 0
```
**örnek**
```
sshfs#guest@guest.login.com:data /mnt/guest fuse uid=1003,gid=100,umask=0,allow_other 0 0
```

- **Proje sayfası** :[http://fuse.sourceforge.net/sshfs.html](%20http://fuse.sourceforge.net/sshfs.html)
- **Wiki sayfası** :[http://fuse.sourceforge.net/sshfs.html](http://fuse.sourceforge.net/sshfs.html). Wiki sayfasını kulanarak birçok bilgiye ulaşabilirsiniz..
