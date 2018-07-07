; ModuleID = file
@msg = internal constant [8 x i8] c"Hello%d\00"
declare i32 @printf(i8*,...)
define i32 @main() {
%a = add i32 1,2
call i32 (i8*,...) @printf(i8* getelementptr inbounds ([8 x i8], [8 x i8]*
@msg, i32 0, i32 0), i32 1)
ret i32 0
}
