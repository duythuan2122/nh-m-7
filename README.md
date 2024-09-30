import math

def giai_phuong_trinh_bac_2(a, b, c):
    if a == 0:
        if b == 0:
            if c == 0:
                return "Phương trình có vô số nghiệm."
            else:
                return "Phương trình vô nghiệm."
        else:
            return f"Nghiệm của phương trình là: x = {-c / b}"
            D = b**2 - 4*a*c
            if D > 0:
        x1 = (-b + math.sqrt(D)) / (2*a)
        x2 = (-b - math.sqrt(D)) / (2*a)
        return f"Các nghiệm của phương trình là: x1 = {x1}, x2 = {x2}"
    elif D == 0:
        x = -b / (2*a)
        return f"Nghiệm kép của phương trình là: x = {x}"
    else:
        return "Phương trình vô nghiệm thực."
a = float(input("Nhập hệ số a: "))
b = float(input("Nhập hệ số b: "))
c = float(input("Nhập hệ số c: "))
ket_qua = giai_phuong_trinh_bac_2(a, b, c)
print(ket_qua)
