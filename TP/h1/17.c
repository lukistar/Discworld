/*
#school - ТУЕС
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Да се разработи програма, която изисква от потребителя да въведе число x, където x e интервала (0;1). Да се намери сумата от сбора на реципрочните стойности за всеки две twin primes. Развитието да продължи докато отношението не стане по-малко то x.
*/
#include<stdio.h>

int main()
{

	long double x;
	
		do
		{
			printf("Vuvedete x v intervala (0,1)\n");
			scanf("%Lf", &x);
		}
		while (x<=0 || x>=1);

	long long prime1 = 3;
	long long prime2 = 5;
	long long number;
	long double sum =  (long double)1/3 + (long double)1/5;	
	long long i;
	int count;
	
		for (number = 7; ((long double)1/prime1+ (long double)1/prime2) >= x ; number+=2)
		{
			count = 0;
			for (i = 1; i <= number; i++)
			{
				if (number % i == 0) count++;
				if (count > 2) break; 
			}
			if (count <= 2)
			{
				prime1 = prime2;
				prime2 = number;
				if (prime2 - prime1 == 2) sum = sum + (long double)1/prime1 + (long double)1/prime2;
				printf("%.20Lf\n", sum);
			}
		}
		printf("Namerenata suma: %.20Lf\n", sum);

return 0;
}
