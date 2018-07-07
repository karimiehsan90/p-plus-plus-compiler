define i32 @main(){
%r$1=add i32 10, 0
%r$2=add i32 %a, 0
%a=add i32 %r$1, 0
br label %label1
label1:
br label %label2
label2:
%r$3=add i32 %a, 0
%r$4=add i32 20, 0
%r$5=icmp slt i32 %r$3, %r$4
br i1 %r$5, label %label4, label %label3
label4:
br label %label1
label3:
ret i32 0
}
