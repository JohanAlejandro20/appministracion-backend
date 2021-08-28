package com.appministracion.springboot.backend.apirest.auth;

public class JwtConfig {
	
	
	public static final String LLAVE_SECRETA = "algina.clave.secreta.12345678";
	
	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\n"
			+ "MIIEpAIBAAKCAQEA15/NqOh0siXJtpIZDq1rEfUWRnqvXC3NBP605LmbSsV6IBYV\n"
			+ "IL06rs1QwYyYAsQTkzY9OjAUr3LQ2+OVnUG9vETCSwUM1wvJfiwR9wa7dWAs4rbu\n"
			+ "aSA7z7AwPIrYGSFkgdJ9XtGTxPsUaLvzclPFGFiB7fvgHFONkxXKOB3Venhxm6NX\n"
			+ "85ceycbAocUY5qsnTl2zA3WVBJosWggLGT96dhRpFVdkZ/bYB85JZyyka7yuSa1Q\n"
			+ "e3MqTHrbDvzZEwOerLVHfTSrJXlwzwIKKoWcGscxBafKbdIgN/waM9/NU2s22V3b\n"
			+ "fZri0fg/c+vH4/w8MUbByeUaf4WZKQzeQvDpGwIDAQABAoIBAQCS7GDGZx6dBQKd\n"
			+ "VI+eYKxEYCv9ejtjJBI/BQ9dits157l/g4yB8m66DUyplZM+zzxHYv31WC3AHwwR\n"
			+ "yNF5hgIy9uctFxPYtD9nqb/UAtJY+F+dW+i32S7oJbW4iyMUfJxvmW2z3jpCTpNp\n"
			+ "iigoDsyN+kEOWEItCwG852wTMMD14TuCxZpVlhkDv4rAQToWFmG4QSnAJ45fk4RC\n"
			+ "tkd/Jrl10TfnqJE0wtCpQuiHx3ZQmERBbPh2ByQp33w2PXDyj51HKaFq7xAQp/I3\n"
			+ "v9NygH88J076gmecCulCZJ/GYnhkBrIRnAUnNWGBGYKSNVHNzj0Ezuopj6HHIDLa\n"
			+ "WRiRIm8BAoGBAPX+we+NXne3rfuhPNCk5jrZRbsLlaOz0Pqvikpp3b6RiaMi7wBL\n"
			+ "yORyBWP0YoNpXUddnK1IGt/mbCnUiZwWnkG0p0ChJsGFTVCvz7wrKUEutZstzdXz\n"
			+ "RfrDmNou2BJm7xxYcCfMBo8LJjmLJI+focIxldCQADcvX9S+B6i7EpbDAoGBAOBk\n"
			+ "1MQ988bAI4KA99mwM5bLqfsUTTGSoeoWBbhOn7CJ8yriK4cSbwtFsJRNu71CftXa\n"
			+ "FIZh2dZc3Tfv6liAv+UjrO8rNXlbm+t5cMu8p73pMBC9+jq/atIAdiH2hmg+ZiWN\n"
			+ "9tXjUydYafzabJL2qdjSxSCZOvOCZo75fXEXoK7JAoGAYyoeneX8RgB6l2xpKqa+\n"
			+ "1MxPitZhrUtInDX1ZogExtS+ilADzre+NTEtsRyMNfNcke9PwJ7HjqjBw58VFiIc\n"
			+ "C9q6bZhJGkwVXchx0qYHjGo69WJijrPx6uO8k3+8xLZP/7o7BCAAKNvSvfG0fF1a\n"
			+ "hQEeJqRWIejsFcPBLKi1FqcCgYEAqcyjFDytE2ChfkeJRbkH0LwczFn4b+K9kx1H\n"
			+ "Bsi4HibFU1YCChvw217I1/BaeESxJbH4hhfVd1ieLY3mj0Id846jdfgEZujje7RR\n"
			+ "nloLtLGYJZMcnwfqFS80NU8PNiLBuPlMJ131tng4+5VtQ2hT7jbP5HMPIOU0Jky0\n"
			+ "l7eBZ8ECgYBOSdZz7KwlFaqxoc7/82McTjbwcEtHRm7KAuC8x6AYgAQosGdhEPxe\n"
			+ "2xOTmqECvIlz0mslGZDFvESHKEDGKfSrMJLcsiNjvaFqmtd7dM4JZnStKEXJXDBL\n"
			+ "4Ts/j9+dc1ckdc/ivtW3m8aKsFb7qTcC67SVb+puZtqv5RR5w2nPww==\n"
			+ "-----END RSA PRIVATE KEY-----"; 

	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA15/NqOh0siXJtpIZDq1r\n"
			+ "EfUWRnqvXC3NBP605LmbSsV6IBYVIL06rs1QwYyYAsQTkzY9OjAUr3LQ2+OVnUG9\n"
			+ "vETCSwUM1wvJfiwR9wa7dWAs4rbuaSA7z7AwPIrYGSFkgdJ9XtGTxPsUaLvzclPF\n"
			+ "GFiB7fvgHFONkxXKOB3Venhxm6NX85ceycbAocUY5qsnTl2zA3WVBJosWggLGT96\n"
			+ "dhRpFVdkZ/bYB85JZyyka7yuSa1Qe3MqTHrbDvzZEwOerLVHfTSrJXlwzwIKKoWc\n"
			+ "GscxBafKbdIgN/waM9/NU2s22V3bfZri0fg/c+vH4/w8MUbByeUaf4WZKQzeQvDp\n"
			+ "GwIDAQAB\n"
			+ "-----END PUBLIC KEY-----";
	
}
