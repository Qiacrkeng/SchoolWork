import random

nums = []

for i in range(10):
    nums.append(round(random.random() * 100))

print(nums)

nums.sort(reverse=True)

print(nums)
