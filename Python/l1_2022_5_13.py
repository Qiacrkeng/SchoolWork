import math
import random

jieguo = ["石头", "剪刀", "布"]
count = 5
score = 0

while count:
    temp = input("Please input :")

    machine_input = jieguo[math.floor(random.random() * 3)]
    print("对方的出手:" + machine_input)

    if (temp == "石头" and machine_input
            == "剪刀") or (temp == "剪刀" and machine_input
                         == "布") or (temp == "布" and machine_input == "石头"):
        score += 1
    elif temp == machine_input:
        1
    else:
        score -= 1
    count -= 1

print("你的分数" + score)
