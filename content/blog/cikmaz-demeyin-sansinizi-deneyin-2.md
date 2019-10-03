---
Title: Çıkmaz demeyin şansınızı deneyin - 2
Date: 2008-04-17T12:27:00+03:00
Author: askin
Category: Programlama
Tags: ["Java", "Programlama", "Şans"]
Slug: cikmaz-demeyin-sansinizi-deneyin-2
Status: published
---

[Buradaki](http://blog.yollu.com/2008/01/22/cikmaz-demeyin-sansinizi-deneyin/) yazımdan esinlenip yazdım bunu. Azıcık java öğrendim artık uygulama yapma zamanıdır. Eminim daha güzel (hatta belki benim ki iğrenç bi koddur(:) yazılabilir. Ama şimdilik bunu yapabiliyorum.

```java
public class Sayisal {
    int[] _kupon = new int[6];
    int _num;
    public Sayisal(){
        int sira = 0;
        while (sira < 6) {
            _num = (int) (1 + Math.random() * 49);
            if (!varmi(_kupon, _num)) 
                _kupon[sira++] = _num;
        }
    }
    
    private boolean varmi(int[] kupon, int num) {
        for (int x: kupon) {if (x == num) return true;}
        return false;
    }
    
    public String toString(){
       String kuponStr = "";
       for (int i = 0; i < 6; i++) kuponStr += (_kupon[i] + " ");
        return kuponStr;
    }
    
    public static void main(String[] args){
        byte kuponSayisi;
        if (args.length == 0) kuponSayisi = 1;
            else kuponSayisi = Byte.parseByte(args[0]);
            
        for (int i = 1; i <= kuponSayisi; i++){
            System.out.print(" " + i + ".kupon: ");
        System.out.println((new Sayisal()).toString());
        }
    }
}
```

`java Sayisal`  
şeklinde girerseniz tek kolon oynayacaktır. eğer  
`java Sayisal 4 `  
derseniz 4 kolon oynayacaktır.  
[Sayısal Kaynak kodları.](/uploads/2008/04/Sayisal.java)  
[Sayısal derlenmiş hali.](/uploads/2008/04/Sayisal.class)
