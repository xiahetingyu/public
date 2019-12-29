package com.xiahe.core;

public class Core {

    public Index[][] core(Index[][] map) throws Exception {//计算
        int count = 0;
        while (count < map.length * map.length) {
            int temp = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    Index index = map[i][j];
                    //扫描和坍缩
                    Support.collapse(i, j, index.value == '0' ? Support.scanner(i, j, map) : null, map);
                    //坍缩为确定值的设置到棋盘上
                    if (index.values.size() == 1) index.values.forEach(value -> index.value = value);
                    if (index.value != '0') temp++;//统计是否有分支
                    if (index.values.size() == 0) return null;//无效分支
                }
            }

            if (count == temp) {//有分支
                int size = map.length, x = -1, y = -1;
                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[i].length; j++) {
                        if (1 < map[i][j].values.size() && map[i][j].values.size() < size) {
                            size = map[i][j].values.size();
                            x = i;
                            y = j;
                        }
                    }
                }

                for (Character value : map[x][y].values) {//递归判断
                    Index[][] indices = Support.deepCopyMap(map);
                    indices[x][y].value = value;
//                    Complex.writer.write(indices);
                    Index[][] result = core(indices);
                    if (result != null) return result;
                }
                return null;
            }
            count = temp;
        }
        return map;
    }

}
