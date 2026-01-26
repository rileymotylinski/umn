# Homework 1

## Problem 1

a) Population - Adult Minnesota residents
b) Sample - 625 Minnesota registered voters
c) Descriptive Statistic - 56% of 625 Minnesota registered voters said they support stricter gun laws in the US
d) Inferential Statistic - Somewhere between 52% and 60% of all adult Minnesota residents support stricter gun control laws in the US

## Problem 2

a) n/a
b)

```R
hist(snowfall, main=" Twin Cities Snowfall 1884-2026 ")
```

c) Unimodal, right skewed. Center ~7.5in, low spread, outliers at 30+in.

d)
    Mean: 20in
    Median: 7.5in
    Standard Deviation: 12in

e)
```R
mean(snowfall) # 9.923944
median(snowfall) # 8.15
sd(snowfall) # 7.353756
```

f)
```R
summary(snowfall)
```
output:
```
Min.    1st Qu. Median  Mean   3rd Qu. Max. 
0.600   4.925   8.150   9.924  12.775  46.400
```

g)
This is an usually small amount of amount snow, considering the first quartile happens at ~5in and the minimum of our dataset is 0.6, meaning 1.7 falls closer to the bottom end. Additionally, 1.7 is significantly smaller than the mean _and_ median by nearly one standard deviation.