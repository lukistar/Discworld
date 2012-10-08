/*
#school - ТУЕС
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Да се разработи програма, която изисква от потребителя да въведе четири числа x, y, w, h където x>0, y>0, w>0, h>0. Числото x е дължината на плоча дървесина, а числото y е височината. Да се определи на колко цели плочи с размери w, h може да се разреже голямата плоча. Да се инициализира масив от 10 елемента. Стойностите на елементите на масива да са първите 10 координати по дължина на плочата, в които тя трябва да се разреже, за да се получат по-малките плочи.
*/



#include<stdio.h>

int insert();
int main()
{
	int x, y, w, h;
	
		printf("Za x: "); x = insert();
		printf("Za y: "); y = insert();
		printf("Za w: "); w = insert();
		printf("Za h: "); h = insert();
		
	int xw = x/w;
	int yh = y/h;
	int xh = y/w;
	int yw = y/h;
	int count = 0;
	int mas[10];
	int count_x = 0;
	int br = 0;
	int Bool = 1;
	
 if(xw*yh == 0 && xh*yw == 0)
 {
 	Bool = 0;
 	printf("Sorry.. opitvate se da narushite zakona za zapazvane na energiqta xD \n");
 }
 else
 {
	if (xw*yh > xh*yw)
	{
		count = xw*yh;
		printf("Broi vuzmojni malki plochi: %d\n", count);
		
		if (xw >= 10) count_x = 10;
		else count_x = xw; 
		for (br = 0; br < count_x; br++)
		{
			mas[br] = (br+1)*(x/xw);
		}		
	}
	else 
	{
		count = xh*yw;
		printf("Broi vuzmojni malki plochi: %d\n", count);
		
		if (xh >= 10) count_x = 10;
		else count_x = xh; 
		for (br = 0; br < count_x; br++)
		{
			mas[br] = (br+1)*(x/xh);
		}		
	}
 }
	int i;
	if (Bool == 1)
	{
		printf("Purvite 10 koordinati(ili vsichkite ako sa pod 10) po x kudeto trqbva da se razreje plochkata: \n");
		for (i = 0; i < count_x; i++) printf("%d\n", mas[i]);	
	}	
		
return 0;
}
int insert()
{
	int x;
	do
	{
		printf("vuvedete chislo po-golqmo ot 0\n");
		scanf("%d", &x);
		if (x <= 0) printf("ERROR! Vuvedete pozvolena stoinost za sushtata promenliva!\n");
	}
	while (x<=0);
	return x;
}
