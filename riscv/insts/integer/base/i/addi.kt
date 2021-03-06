package venusbackend.riscv.insts.integer.base.i

import venusbackend.riscv.insts.dsl.types.base.ITypeInstruction

val addi = ITypeInstruction(
        name = "addi",
        opcode = 0b0010011,
        funct3 = 0b000,
        eval16 = { a, b -> (a + b).toShort() },
        eval32 = { a, b -> a + b },
        eval64 = { a, b -> a + b },
        eval128 = { a, b -> a + b }
)
