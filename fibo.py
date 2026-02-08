
def fibo(n):
    if n == 0:
        return 0
    if n == 1:
        return 1
    a = 0
    b = 1
    c = 0
    counter = 1
    while counter < n:
        c = b + a
        a = b
        b = c
        counter += 1
    return c

for i in range(11):
    print(fibo(i), end = ' ')