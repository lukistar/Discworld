/*
#school - ТУЕС
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Да се разработи програма, която изисква от потребителя да въведе целочислено число x, където 0<=x<10. Да се инициализира масив от 10 елемента. Да се намерят първите 10 стойности на функцията cos(x) в интервала [0; +∞), в които третата цифра след десетичната запетая е x. Пример при cos(1) = 0.540302306 третата цифра след десетичната запетая е 0. При cos(2) = -0.416146837 третата цифра след десетичната запетая е 6. Намерените стойности да се зададат като стойности на елементите в масива. Елементите на масива да се изведат на стандартния изход.
*/

#include<stdio.h>
#include<math.h>

int main()
{
	int x = -1;
	
	while ((x<0)||(x>=10))
	{
		printf("Vuvedete chislo v intervala [0,10)\n");
		scanf("%d", &x);
		if (x<=0 || x>=10) printf("@@@@ ERROR! Chislo trqbva da e v intervala [0,10) @@@@\n");
	}
	double mas[10];
	int y;
	double number;
	int number2;
	int count = 0;
	for (y=0; y>-1;y++)
	{
		number = cos(y);
		printf(" A? : %f\n", number);
		number*=1000;
		number2 = (int)number;
		printf(" A? : %d\n", number2);
		number2%=10;
		printf(" A? : %d\n", number2);
		if ((number2 == x)||(number2 == -x))
		{
			mas[count] = cos(y);
			count++;
			if (count == 10) break;
		} 
	}
	int i;
	for (i=0; i<10; i++)
	{
		printf("%f\n", mas[i]);
	}

return 0;
}
