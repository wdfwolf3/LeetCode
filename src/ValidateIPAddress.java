public class ValidateIPAddress {
    public static void main(String args[]) {
        String ip = "2001:0db8:85a3:0000:0A0:8A2E:0370:7334";
        String ipv4 = "174.1.1.1.";
        System.out.println(IPv4(ipv4));
        System.out.println(IPv6(ip));
    }

    public static boolean IPv4(String ipv4) {
        if (ipv4 == null || ipv4.length() == 0) {
            return false;//�ַ���Ϊ�ջ��߿մ�
        }
        String[] parts = ipv4.split("\\.");//��Ϊjava doc���Ѿ�˵��, split�Ĳ�����reg, ��������ʽ, �����"|"�ָ�, ����ʹ��"//|"
        if (parts.length != 4) {
            return false;//�ָ����������Ͳ���4������
        }
        int len = 0;
        for (int i = 0; i < parts.length; i++) {
            len += parts[i].length();
        }
        if (len + 3 != ipv4.length())
            return false;
        for (int i = 0; i < parts.length; i++) {
            try {
                int n = Integer.parseInt(parts[i]);
                if (n == 0 && parts[i].length() == 1)
                    continue;
                if (n < 0 || n > 255)
                    return false;//���ֲ�����ȷ��Χ��
                if (parts[i].charAt(0) == '0')
                    return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    public static boolean IPv6(String ipv6) {
        String[] parts = ipv6.split(":");//��Ϊjava doc���Ѿ�˵��, split�Ĳ�����reg, ��������ʽ, �����"|"�ָ�, ����ʹ��"//|"
        if (parts.length != 8) {
            return false;//�ָ����������Ͳ���4������
        }
        int len = 0;
        for (int i = 0; i < parts.length; i++) {
            len += parts[i].length();
        }
        if (len + 7 != ipv6.length())
            return false;
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if (part.length() > 4 || part.length() == 0)
                return false;
            else {
                for (int j = 0; j < part.length(); j++) {
                    char c = part.charAt(j);
                    if ((c <= '9' && c >= '0') || (c <= 'F' && c >= 'A') || (c <= 'f' && c >= 'a'))
                        continue;
                    else
                        return false;
                }
            }
        }
        return true;
    }
}
