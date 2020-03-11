---
Title: C ile Komut Satırı Argumanları ve Parametreleri
Date: 2009-07-10T18:01:00+03:00
Author: Aşkın Özgür
Category: Programlama
Tags: ["c/c++"]
Slug: c-ile-komut-satiri-argumanlari-ve-parametreleri
Status: published
---

![Terminal](/uploads/2009/07/gnome-terminal.png "Terminal")Komut satırı programları -h yada --help gibi parametreler alırlar. Bu alınan parametrelerin kolay kullanılması için *getopt* adında bir kütüphane yaratılmış. Bu kütüphane kullanlanılarak çok rahat böyle programlar yazılabilir.
Bende bunun için küçük bir örnek yazdım.

```C
#include <stdio.h>
#include <stdlib.h>
#include <getopt.h>

int print_usage ( void );

int main (int argc, char* argv[])
{
  int next_option;
  char* output;
  char* input;
  char color = 47;

  /**
   * kisa parametler burda tanimli
   *  ardindan parametre alanlar : ile bitiyor
   *  orn: o: bir parametre aliyor b almiyor
   *  -o kelebek yada -b gibi
   */
  const char* const short_options = "hbro:i:";

  /**
   * Burdada uzun hallerini tanimliyoruz.
   *  beraberinde kisa karsiliklarida var.
   */
  const struct option long_options[] = {
    {"help",   no_argument, 0, 'h'},
    {"blue",   no_argument, 0, 'b'},
    {"red",    no_argument, 0, 'r'},
    {"input",  required_argument, 0, 'i'},
    {"output", required_argument, 0, 'o'}
  };

  /**
   * Burda sirayla verilen argumalari aliyoruz
   */
  do {
    next_option = getopt_long(argc,
			      argv,
			      short_options,
			      long_options,
			      NULL);
    switch(next_option) {
    case 'h': // -h or --help
      print_usage();
      return 0;
      break;

    case 'o': // -o or --or
      output = optarg;
      break;

    case 'i': // -i or --i
      input = optarg;
      break;

    case 'b': // -b or --blue
      color = 44;
      break;

    case 'r': // -r or --red
      color = 41;
      break;

    case -1:
      break;

    default:
      abort();
    }
  } while (next_option != -1);

  printf("%c[%d;%dmInput : %s%c[%dm\n", 27, 1, color, input, 27, 0);
  printf("%c[%d;%dmOutput: %s%c[%dm\n", 27, 1, color, output, 27, 0);


  return 0;
}

int print_usage ( void ) {
  printf("   --help   or -h for help\n"
	 "   --output or -o for output\n"
	 "   --input  or -i for input\n"
	 "   --blue   or -b for blue output\n"
	 "   --red    or -r for red output\n");
  return 0;
}
```

[Örnek](/uploads/2009/07/clexmp.c)
