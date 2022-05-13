// 第一题
// B E F G D

// 第二题
// 159.8

/**
 *
 * @param {Number} x 特征 x
 * @param {Number} y 特征 y
 * @param {Number} z 特征 z
 * @param {Number} k 选择数量
 * @param {Array[]} array 数据中心
 * @param {Number} n 数据总数量
 * 注意这里是不分种类的
 */
const KNN = (x, y, z, k, array, n) => {
  const dist = new Array(n).fill(Number.MAX_VALUE);

  for (let i = 0; i < n; i++) {
    dist[i] = Math.hypot(array[i][0] - x, array[i][1] - y, array[i][2] - z); // 向量模
  }
  // 取最近的距离目标
  let sum = 0,
    minIndex;
  for (let i = 0; i < k; i++) {
    minIndex = i;
    for (let j = 1; j < n; j++) {
      if (dist[minIndex] > dist[j]) {
        minIndex = j;
      }
    }
    // console.log(String.fromCharCode(minIndex + 65));
    // 累积为目前生态内的最大目的值
    sum += array[minIndex][3];
    dist[minIndex] = Number.MAX_VALUE; // 一次性
  }
  // 经过特征达到的最终目的值
  return sum / k;
};
// const array = [
//   [5, 1, 0, 300],
//   [3, 1, 1, 225],
//   [1, 1, 0, 75],
//   [4, 0, 1, 200],
//   [4, 0, 0, 150],
//   [2, 0, 0, 50],
// ];
// 本次目的拿到面包的制作（即可能售出的）数量
const array = [
  [5, 1, 0, 304],
  [3, 1, 1, 223],
  [1, 1, 0, 78],
  [4, 0, 1, 216],
  [4, 0, 0, 141],
  [3, 0, 1, 162],
  [2, 0, 0, 57],
];
const n = array.length;

import ReadLine from "readline";
const readline = ReadLine.createInterface({
  input: process.stdin,
  output: process.stdout,
});
// 用户数入逻辑，异步代码
readline.question("输入x特征 ", (inputX) => {
  const x = inputX;
  readline.question("输入y特征 ", (inputY) => {
    const y = inputY;
    readline.question("输入z特征 ", (inputZ) => {
      const z = inputZ;
      readline.question("输入选择邻近的个数 ", (inputK) => {
        const k = inputK;
        const result = KNN(x, y, z, k, array, n);
        console.log("预计要制作的面包数为", result);
        readline.close();
      });
    });
  });
});
