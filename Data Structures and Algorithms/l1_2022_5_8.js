function knapSack(capacity, weights, values, n) {
    const kS = [];
    for (let i = 0; i <= n; i++) {
      kS[i] = [];
    }
  
    for (let i = 0; i <= n; i++) {
      for (let w = 0; w <= capacity; w++) {
        // 每列都是可以裝的當前最大容量的價值
        if (i === 0 || w === 0) {
          kS[i][w] = 0;
        } else if (weights[i - 1] <= w) {
          // 當前的物品必須小於增量容量
          const thisWeight = weights[i - 1]; // 如果當前容量的價值最大，那麼當前所在列將會被刷新
          const a = values[i - 1] + kS[i - 1][w - thisWeight]; // 減掉了重量後，取這個重量上一次能裝的最大價值
          const b = kS[i - 1][w]; // 上一次最大價值，因為有可能當前重量是很小的
          kS[i][w] = a > b ? a : b;
        } else {
          kS[i][w] = kS[i - 1][w];
        }
      }
    }
    return kS[n][capacity];
}
  
const capacity = 4,weights = [3, 4, 1, 1, 2],
    values = [6500 ,6900 ,1000 ,6000 ,3500],
    n = 5;
console.log(knapSack(capacity,weights,values,n));