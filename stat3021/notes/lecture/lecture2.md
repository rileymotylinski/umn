# Lecture 2 1.2-1.5: More R
__Categorical__ (qualitative) - a subject is a part of a certain group/category
__Numerical__ (quantitative) - something that can be assigned a numerical value
1) Discrete - variables take on a _set_ of separate numbers
2) Continuous - variables form a _interval_ of possible values

## Graphical Summaries: Quantitative Variables
`pie(x)` - creates a pie chart given a vector of non-negative numbers
`barplot(x)` - creates a bar chart from a vector of numbers (categories of data)
`hist(x)` - creates a histogram ( bar chart from continuous data) from a vector of numbers 
`mean(x)` - averages vector
`med(x)` - median of vector
`summary(x)` - everything you need 
`boxplot(x ~ categorical)` - create a box plot seperated by some categorical variable.
__Distribution__ - the values a variable takes and how often those values occur
__Uni-modal__ - one peak
1) symmetric
- mean/median are similar
2) right-skew (long tail on right side)
3) left-skew (long tail on left side)

__Bimodal__ - two peaks
__Uniform__ - flat top

variable on x axis, frequency on right axis

__Mean__ (x̄) - average of all observations
__Median__ (M) middle number when numbers are ordered from smallest -> largest
- Median is __Resistant__, meaning extreme values hold little (if any) bearing on it as a number
__Range__ - max-min. Not resistant because it can be sway by the extremes.

__Percentile__ - the pth percentile of a distribution is the value below which p% of the observations fall

__First Quartile__ - the number 1/4 through the data set. 25th percentile
__Second Quartile__ = middle part of data. SAME AS MEDIAN!
__Third Quartile__ - the number which the top 25% of the distribution falls
__Interquartile Range__ Q3-Q1. Larger IQR, more spread. __Resistant__ bc only calculated with middle 50% of the data

---
## Box Plot
- five number summary
    - top/bottom bar - min/max of data set
    - bottom box - q1
    - line in box - q2
    - top of box - q3
    - sometimes are outliers are marked by stars/circles/etc.
- iqr is the height of the middle box
- side by side box plot are good to compare different distributions

## Measures of Spread: Standard Deviation
__Deviation__ - how each sample deviates from the mean.(x_bar - x)^2 Squared to take the absolute value
__Sample Variance__ (s)- mean of all of the deviations. Total of deviations is divided by n-1 for nicer calculations. 

__Standard deviation__ s^0.5 . Sometimes also just s?
- s is dependent on the mean, not median
- s >= 0
- easier to compute than media bc don't have to sort (big data)