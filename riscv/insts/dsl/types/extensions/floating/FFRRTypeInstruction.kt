package venusbackend.riscv.insts.dsl.types.extensions.floating

import venusbackend.riscv.insts.dsl.types.Instruction
import venusbackend.riscv.insts.dsl.disasms.extensions.floating.FFRRTypeDisassembler
import venusbackend.riscv.insts.dsl.formats.base.RTypeFormat
import venusbackend.riscv.insts.dsl.impls.NoImplementation
import venusbackend.riscv.insts.dsl.impls.extensions.floating.b32.FFRRTypeImplementation32
import venusbackend.riscv.insts.dsl.parsers.extensions.floating.FFRRTypeParser
import venusbackend.riscv.insts.floating.Decimal

class FFRRTypeInstruction(
    name: String,
    opcode: Int,
    funct3: Int,
    funct7: Int,
        // eval16: (Short, Short) -> Short = { _, _ -> throw NotImplementedError("no rv16") },
    eval32: (Decimal, Decimal) -> Int // ,
        // eval64: (Long, Long) -> Long = { _, _ -> throw NotImplementedError("no rv64") },
        // eval128: (Long, Long) -> Long = { _, _ -> throw NotImplementedError("no rv128") }
) : Instruction(
        name = name,
        format = RTypeFormat(opcode, funct3, funct7),
        parser = FFRRTypeParser,
        impl16 = NoImplementation,
        impl32 = FFRRTypeImplementation32(eval32),
        impl64 = NoImplementation,
        impl128 = NoImplementation,
        disasm = FFRRTypeDisassembler
)