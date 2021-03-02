import java.io.*;

class DataStreamDemo {
    public static void main(String[] args) throws Exception{
        // 将数据写入文件
        DataOutputStream out = new DataOutputStream(new FileOutputStream("order.txt"));
        double prices[] = {18.99, 9.22, 14.22, 5.22, 4.21};
        int units[] = {10, 10, 20, 39, 40};
        String [] name = {"T恤衫", "杯子", "洋娃娃", "大头针", "钥匙链"};

        for(int i = 0; i < prices.length; ++i)
        {
            //写入价格
            out.writeDouble(prices[i]);
            out.writeChar('\t');
            //写入数目
            out.writeInt(units[i]);
            out.writeChar('\t');
            //写入产品名称,行尾换行
            out.writeChars(name[i]);
            out.writeChar('\n');
        }
        out.close();

        //将数据读出
        DataInputStream in = new DataInputStream(new FileInputStream("order.txt"));
        double price;
        int unit;
        StringBuffer tempName;
        double total = 0.0;

        try{ // 文本读完后会抛出 EOF 异常
            while(true){
                price = in.readDouble();
                in.readChar();//跳过tab

                unit = in.readInt();
                in.readChar();//跳过tab

                char c;
                tempName = new StringBuffer();
                while((c=in.readChar()) != '\n')
                    tempName.append(c);
                System.out.println("订单信息：" + "产品名称：" + tempName
                        + ", \t 数量：" + unit + ", \t 价格" + price);
                total += unit*price;
            }
        }
        catch (EOFException e){
            System.out.println("\n 共需要：" + total + "元");
        }
        in.close();
    }
}
