#include <stdio.h>

#define MAXBIT 100 // 最大位数
#define MAXVALUE 81192 // 最大值
#define MAXLEFT 30 // 左子树最大数量
#define MAXNODE MAXLEFT * 2 - 1 // 通过最大子树数量确定构建后最大节点数
// 节点数据
typedef struct {
    int weight; // 权值
    int parent; // 父节点
    int leftChild; // 左节点
    int rightChild; // 右节点
}HNodeType;
// 
typedef struct {
    int bit[MAXBIT];
    int start;
}HCodeType;
void createHuffmanTree(HNodeType*, int);// 创建哈夫曼树

int main(void) {
    int n = 0;
    printf("please input number of nodes ");
    scanf("%d", &n);
    HNodeType huffNode[MAXNODE]; // 节点数组，也可以改成 n * 2 - 1，不过这样规避了只有1个节点的情况
    HCodeType huffCode[MAXNODE]; // 编码数组
    createHuffmanTree(huffNode, n);
    printf("---------------------------------\n");
    printf("array   index   weight  parent  leftChild   rightChild \n");
    // 可视化输出数组
    for (int i = 0;i < 2 * n - 1;i++) {
        printf("    %4d%8d%10d%12d%14d\n", i, huffNode[i].weight, huffNode[i].parent, huffNode[i].leftChild, huffNode[i].rightChild);
    }
    // 编码
    for (int i = 0;i < n;i++) {
        HCodeType temp;
        temp.start = n - 1;
        int thisIndex = i;
        int parentIndex = huffNode[thisIndex].parent; // 当前节点的父节点
        while (parentIndex != -1) { // 不是树根
            if (huffNode[parentIndex].leftChild == thisIndex) { // 左边
                temp.bit[temp.start] = 1;
            } else { // 右边
                temp.bit[temp.start] = 0;
            }
            temp.start--; // 降一位
            // 回溯
            thisIndex = parentIndex;
            parentIndex = huffNode[thisIndex].parent;
        }
        // 将其保存，从低位到高位
        for (int j = temp.start + 1;j < n;j++) {
            huffCode[i].bit[j] = temp.bit[j];
        }
        huffCode[i].start = temp.start;
    }
    // 输出编码
    for (int i = 0;i < n;i++) {
        printf("%d coding is ", huffNode[i].weight);
        for (int j = huffCode[i].start + 1;j < n;j++) {
            printf("%d", huffCode[i].bit[j]); // 摸拟的二进制数
        }
        printf("\n");
    }
    return 0;
}
// 创建哈夫曼树
void createHuffmanTree(HNodeType* huffNode, int n) {
    int m1, m2, x1, x2;
    // 初始化，构建后只有2n - 1个节点
    for (int i = 0;i < 2 * n - 1;i++) {
        huffNode[i].weight = 0; // 最小的情况
        huffNode[i].parent = -1;
        huffNode[i].leftChild = -1;
        huffNode[i].rightChild = -1;
    }
    for (int i = 0;i < n;i++) {
        printf("input the %d of weight ", i + 1);
        scanf("%d", &huffNode[i].weight);
    }
    // 权值最小，无父节点的两个节点，只需要遍历原始数据n - 1个节点
    for (int i = 0; i < n - 1; i++) {
        m1 = m2 = MAXVALUE; // 要两个无父节点且权值最小的两个节点的权值
        x1 = x2 = 0; // 哈夫曼树顺序表中的位置
        for (int j = 0;j < n + i;j++) {
            // 先拿第一个候选权值，必须没有父节点
            if (huffNode[j].weight < m1 && huffNode[j].parent == -1) {
                m2 = m1;
                x2 = x1;
                m1 = huffNode[j].weight;
                x1 = j; // 拿到对应数组的下标
            } else if (huffNode[j].weight < m2 && huffNode[j].parent == -1) {
                // 接着再拿第二个候选权值，也是没有父节点
                m2 = huffNode[j].weight;
                x2 = j; // 对应数组的下标
            }
        }
        // 保存为对应数组的下标
        huffNode[x1].parent = n + i;
        huffNode[x2].parent = n + i;
        huffNode[n + i].weight = huffNode[x1].weight + huffNode[x2].weight; // 哈夫曼新节点权值
        // 注意保存的不是引用
        huffNode[n + i].leftChild = x1;
        huffNode[n + i].rightChild = x2;
    }
}