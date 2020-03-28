package solutions.examinationquestion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
 * 所有的IP地址划分为 A,B,C,D,E五类
 * A类地址1.0.0.0~126.255.255.255;
 * B类地址128.0.0.0~191.255.255.255;
 * C类地址192.0.0.0~223.255.255.255;
 * D类地址224.0.0.0~239.255.255.255；
 * E类地址240.0.0.0~255.255.255.255
 * <p>
 * 私网IP范围是：
 * 10.0.0.0～10.255.255.255
 * 172.16.0.0～172.31.255.255
 * 192.168.0.0～192.168.255.255
 * <p>
 * 子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
 * 注意二进制下全是1或者全是0均为非法
 * <p>
 * 注意：
 * 1. 类似于【0.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时可以忽略
 * 2. 私有IP地址和A,B,C,D,E类地址是不冲突的
 *
 * @author chujunjie
 */
public class Main18 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = 0, b = 0, c = 0, d = 0, e = 0;
        int err = 0;
        int pri = 0;
        String str;
        String[] ipMask;
        String[] ip;
        int i;

        while ((str = br.readLine()) != null) {
            ipMask = str.split("~");
            ip = ipMask[0].split("\\.");
            // count error mask
            if (checkMask(ipMask[1])) {
                // count ip
                if (checkIP(ip)) {
                    i = Integer.parseInt(ip[0]);
                    if (i >= 1 && i <= 126) {
                        a++;
                        if (i == 10) {
                            pri++;
                        }
                    } else if (i >= 128 && i <= 191) {


                        b++;
                        if (i == 172 && Integer.parseInt(ip[1]) >= 16 && Integer.parseInt(ip[1]) <= 31) {
                            pri++;
                        }
                    } else if (i >= 192 && i <= 223) {
                        c++;
                        if (i == 192 && Integer.parseInt(ip[1]) == 168) {
                            pri++;
                        }
                    } else if (i >= 224 && i <= 239) {
                        d++;
                    } else if (i >= 240 && i <= 255) {
                        e++;
                    }
                } else {
                    err++;
                }
            } else {
                err++;
            }
        }

        // output
        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + err + " " + pri);
    }

    private static boolean checkMask(String mask) {
        // check mask
        String[] maskArr = mask.split("\\.");
        if ("255".equals(maskArr[0])) {
            if ("255".equals(maskArr[1])) {
                if ("255".equals(maskArr[2])) {
                    return "254".equals(maskArr[3]) || "252".equals(maskArr[3]) || "248".equals(maskArr[3]) ||
                            "240".equals(maskArr[3]) || "224".equals(maskArr[3]) || "192".equals(maskArr[3]) ||
                            "128".equals(maskArr[3]) || "0".equals(maskArr[3]);
                } else if ("254".equals(maskArr[2]) || "252".equals(maskArr[2]) || "248".equals(maskArr[2]) ||
                        "240".equals(maskArr[2]) || "224".equals(maskArr[2]) || "192".equals(maskArr[2]) ||
                        "128".equals(maskArr[2]) || "0".equals(maskArr[2])) {
                    return "0".equals(maskArr[3]);
                } else {
                    return false;
                }
            } else if ("254".equals(maskArr[1]) || "252".equals(maskArr[1]) || "248".equals(maskArr[1]) ||
                    "240".equals(maskArr[1]) || "224".equals(maskArr[1]) || "192".equals(maskArr[1]) ||
                    "128".equals(maskArr[1]) || "0".equals(maskArr[1])) {
                return "0".equals(maskArr[2]) && "0".equals(maskArr[3]);
            } else {
                return false;
            }
        } else if ("254".equals(maskArr[0]) || "252".equals(maskArr[0]) || "248".equals(maskArr[0]) ||
                "240".equals(maskArr[0]) || "224".equals(maskArr[0]) || "192".equals(maskArr[0]) ||
                "128".equals(maskArr[0]) || "0".equals(maskArr[0])) {
            return "0".equals(maskArr[1]) && "0".equals(maskArr[2]) && "0".equals(maskArr[3]);
        } else {
            return false;
        }
    }

    private static boolean checkIP(String[] ip) {
        return ip.length == 4 && !"".equals(ip[0]) && !"".equals(ip[1]) && !"".equals(ip[2]) && !"".equals(ip[3]);
    }
}