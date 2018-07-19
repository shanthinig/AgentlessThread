/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AgentlessThread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author hummer
 */
public class AgentlessThread {

    static String currentPath = System.getProperty("user.dir");
//    public static final String WINDOWS_CPU_COUNT_COMMAND = "echo %NUMBER_OF_PROCESSORS% && echo done";
//    public static final String WINDOWS_CPU_COUNT_COMMAND = "chcp 1252 & ipconfig & echo done & wmic exit & exit";
    public static final String WINDOWS_CPU_COUNT_COMMAND = "wmic cpu get NumberOfCores & echo done";
//    public static final String WINDOWS_OSNAME_COMMAND = "wmic os get Caption";
    public static final String WINDOWS_OSNAME_COMMAND = "wmic os get Caption < NUL: & echo done";
//    public static final String WINDOWS_RAMSIZE_COMMAND = "wmic memorychip get capacity & echo done";
    public static final String WINDOWS_RAMSIZE_COMMAND = "wmic memorychip get capacity < NUL: & echo done";
//    public static final String WINDOWS_CPUARCH_COMMAND = "wmic cpu get description & echo done";
    public static final String WINDOWS_CPUARCH_COMMAND = "wmic cpu get description < NUL: & echo done";
//    public static final String WINDOWS_PRIVATEIP_COMMAND = "wmic nicconfig get ipaddress & echo done";
    public static final String WINDOWS_PRIVATEIP_COMMAND = "wmic nicconfig get ipaddress < NUL: & echo done";
    public static final String WINDOWS_CPU_RUNTIME_COMMAND = "wmic os get LastBootUpTime, LocalDateTime /format:list && FOR /F \"tokens=1,2,3\" %A IN ('netstat -e ^| find \"Bytes\"') DO (echo %A,%B,%C) & echo done";
    public static final String WINDOWS_OSARCH_COMMAND = "wmic os get osarchitecture";
    public static final String WINDOWS_SYSTEMINFO_COMMAND = "systeminfo & echo done";
    public static final String WINDOWS_DATE_COMMAND = "date /t & echo done";
    public static final String WINDOWS_TIME_COMMAND = "time /t";
    public static final String WINDOWS_PUBLICIP_COMMAND = "nslookup myip.opendns.com resolver1.opendns.com & echo done";
    public static final String WINDOWS_DEVICEINFO_COMMAND = "echo list disk | diskpart & echo done ";
    public static final String WINDOWS_BIOS_VERSION_COMMAND = "wmic bios get smbiosbiosversion < NUL: & echo done ";
    public static final String WINDOWS_SYSTEM_MANUFACTURER_COMMAND = "wmic computersystem get model,name,manufacturer,systemtype < NUL: & echo done ";
    public static final String WINDOWS_RAMDETAILS_COMMAND = "wmic OS get FreePhysicalMemory < NUL: & echo RAM_data_end & echo done";
    
    
//    String ip = "192.168.0.209";
    String ip = "192.168.0.140";
    String username = "Administrator";
//    String password = "corent@123";
    String password = "corent123$$";
    String filename ="test.txt";
    BufferedReader bufferedInputReader = null;
    BufferedReader bufferedErrorReader = null;
    OutputStreamWriter outputStreamWriter = null;
    BufferedWriter bufferedWriter = null;

    public static void main(String[] args) {
//        String ip = args[0];
//        String username = args[1];
//        String password = args[2];
//          String filename =args[3];
        AgentlessThread thread = new AgentlessThread();
        thread.doScan();
//        thread.doScan(ip,username,password,filename);
    }

    private void doScan() 
//    private void doScan(String ip,String username,String password,String filename)
    {
        long id;
        try {
            String command = currentPath + File.separator + "paexec.exe \\\\" + ip + " -u " + username + " -p " + password + " cmd.exe -lo "+currentPath+File.separator+filename;
            System.out.println("Maincommand = " + command);

            Process process = getProcess(command);
            Thread.sleep(30000);

            System.out.println("process isalive ???? = " + process.isAlive());
            System.out.println("--------------------------- ");
            String deviceInfo = getDeviceInfo(process);
            id = Thread.currentThread().getId();
            System.out.println(id + "\t" + ip + "\t" + deviceInfo);
            System.out.println("--------------------------- ");
            String cpuCount = getCpuCount(process);
            id = Thread.currentThread().getId();
            System.out.println(id + "\t" + ip + "\t" + cpuCount);
            System.out.println("--------------------------- ");
            System.out.println("process isalive ???? = " + process.isAlive());
            System.out.println("--------------------------- ");
            String osName = getOsName(process);
            id = Thread.currentThread().getId();
            System.out.println(id + "\t" + ip + "\t" + osName);
            System.out.println("--------------------------- ");
            String ramSize = getRamSize(process);
            id = Thread.currentThread().getId();
            System.out.println(id + "\t" + ip + "\t" + ramSize);
            System.out.println("--------------------------- ");
            String cpuArch = getCpuArch(process);
            id = Thread.currentThread().getId();
            System.out.println(id + "\t" + ip + "\t" + cpuArch);
            System.out.println("--------------------------- ");
            String privateIP = getPrivateIP(process);
            id = Thread.currentThread().getId();
            System.out.println(id + "\t" + ip + "\t" + privateIP);
            System.out.println("--------------------------- ");
            String cpuRunTime = getCpuRuntime(process);
            id = Thread.currentThread().getId();
            System.out.println(id + "\t" + ip + "\t" + cpuRunTime);
            System.out.println("--------------------------- ");
            String osArch = getosArch(process);
            id = Thread.currentThread().getId();
            System.out.println(id + "\t" + ip + "\t" + osArch);
            System.out.println("--------------------------- ");
            String systemInfo = getSystemInfo(process);
            id = Thread.currentThread().getId();
            System.out.println(id + "\t" + ip + "\t" + systemInfo);
            System.out.println("--------------------------- ");
            String systemDate = getSystemDate(process);
            id = Thread.currentThread().getId();
            System.out.println(id + "\t" + ip + "\t" + systemDate);
            System.out.println("--------------------------- ");
            String systemTime = getSystemTime(process);
            id = Thread.currentThread().getId();
            System.out.println(id + "\t" + ip + "\t" + systemTime);
            System.out.println("--------------------------- ");
            String publicIP = getPublicIP(process);
            id = Thread.currentThread().getId();
            System.out.println(id + "\t" + ip + "\t" + publicIP);
            System.out.println("--------------------------- ");
            String biosVersion = getBIOSVersion(process);
            id = Thread.currentThread().getId();
            System.out.println(id + "\t" + ip + "\t" + biosVersion);
            System.out.println("--------------------------- ");
            String systemManufacturer = getSystemManufacturer(process);
            id = Thread.currentThread().getId();
            System.out.println(id + "\t" + ip + "\t" + systemManufacturer);
            System.out.println("--------------------------- ");
            String ramDetails = getRamDetails(process);
            id = Thread.currentThread().getId();
            System.out.println(id + "\t" + ip + "\t" + ramDetails);

            killProcess(process, "getCpuCount");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (bufferedInputReader != null) {
                    bufferedInputReader.close();
                }
                if (bufferedErrorReader != null) {
                    bufferedErrorReader.close();
                }
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private Process getProcess(String command) throws IOException {
        String line = "";
        Process process;
        process = Runtime.getRuntime().exec(command);
        System.out.println("process = " + process);
        
        return process;
    }

    private String getCpuCount(Process process) {
        String cpuCount = "";
        int count = 0;
        String line = "";
        try {
            process.getOutputStream().flush();
            outputStreamWriter = new OutputStreamWriter(process.getOutputStream());
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            System.out.println("CpuCount_command = " + WINDOWS_CPU_COUNT_COMMAND);
            bufferedWriter.write(WINDOWS_CPU_COUNT_COMMAND);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            bufferedInputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            bufferedErrorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String bufferReader = checkBufferReadyState(bufferedInputReader, bufferedErrorReader, "getCpuCount");
            if (bufferReader.equals("input")) {
                while ((line = bufferedInputReader.readLine()) != null) {
                    System.out.println("line = " + line);

                    if (!line.trim().equals("") && line.trim().matches("\\d+")) {
                        cpuCount = line.trim();
                        count = count + Integer.parseInt(cpuCount);
                    }
                    if (line.trim().equals("done")) {
                        break;
                    }
                }
            }
            if (bufferReader.equals("error")) {
                while ((line = bufferedErrorReader.readLine()) != null) {
                    System.out.println("error line = " + line);
                }
            }
            cpuCount = String.valueOf(count);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cpuCount;
    }

    private String getOsName(Process process) {
        String line = "";
        String osName = "";
        try {
            process.getOutputStream().flush();
            outputStreamWriter = new OutputStreamWriter(process.getOutputStream());
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            System.out.println("OsName_command = " + WINDOWS_OSNAME_COMMAND);
            bufferedWriter.write(WINDOWS_OSNAME_COMMAND);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            bufferedInputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            bufferedErrorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String bufferReader = checkBufferReadyState(bufferedInputReader, bufferedErrorReader, "osName");
            if (bufferReader.equals("input")) {
                while ((line = bufferedInputReader.readLine()) != null) {
                    System.out.println("line = " + line);
                    if (line.startsWith("done")) {
                        osName = line;
                        break;
                    }
                }
            }
            if (bufferReader.equals("error")) {
                while ((line = bufferedErrorReader.readLine()) != null) {
                    System.out.println("error line = " + line);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return osName;
    }

    private String getRamSize(Process process) {
        String line = "";
        String ramSize = "";
        try {
            process.getOutputStream().flush();
            outputStreamWriter = new OutputStreamWriter(process.getOutputStream());
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            System.out.println("RamSize_command = " + WINDOWS_RAMSIZE_COMMAND);
            bufferedWriter.write(WINDOWS_RAMSIZE_COMMAND);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            bufferedInputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            bufferedErrorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String bufferReader = checkBufferReadyState(bufferedInputReader, bufferedErrorReader, "ramSize");
            if (bufferReader.equals("input")) {
                while ((line = bufferedInputReader.readLine()) != null) {
                    System.out.println("line = " + line);

                    if (line.startsWith("done")) {
                        ramSize = line;
                        break;
                    }
                }
            }
            if (bufferReader.equals("error")) {
                while ((line = bufferedErrorReader.readLine()) != null) {
                    System.out.println("error line = " + line);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ramSize;
    }

    private String getCpuArch(Process process) {
        String line = "";
        String cpuArch = "";
        try {
            process.getOutputStream().flush();
            outputStreamWriter = new OutputStreamWriter(process.getOutputStream());
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            System.out.println("CpuArch_command = " + WINDOWS_CPUARCH_COMMAND);
            bufferedWriter.write(WINDOWS_CPUARCH_COMMAND);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            bufferedInputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            bufferedErrorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String bufferReader = checkBufferReadyState(bufferedInputReader, bufferedErrorReader, "cpuArch");
            if (bufferReader.equals("input")) {
                while ((line = bufferedInputReader.readLine()) != null) {
                    System.out.println("line = " + line);
                    if (line.startsWith("done")) {
                        cpuArch = line;
                        break;
                    }
                }
            }
            if (bufferReader.equals("error")) {
                while ((line = bufferedErrorReader.readLine()) != null) {
                    System.out.println("error line = " + line);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cpuArch;
    }

    private String getPrivateIP(Process process) {
        String line = "";
        String privateIP = "";
        try {
            process.getOutputStream().flush();
            outputStreamWriter = new OutputStreamWriter(process.getOutputStream());
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            System.out.println("PrivateIP_command = " + WINDOWS_PRIVATEIP_COMMAND);
            bufferedWriter.write(WINDOWS_PRIVATEIP_COMMAND);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            bufferedInputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            bufferedErrorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String bufferReader = checkBufferReadyState(bufferedInputReader, bufferedErrorReader, "privateIP");
            if (bufferReader.equals("input")) {
                while ((line = bufferedInputReader.readLine()) != null) {
                    System.out.println("line = " + line);
                    if (line.startsWith("done")) {
                        privateIP = line;
                        break;
                    }
                }
            }
            if (bufferReader.equals("error")) {
                while ((line = bufferedErrorReader.readLine()) != null) {
                    System.out.println("error line = " + line);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return privateIP;
    }

    private String getCpuRuntime(Process process) {
        String line = "";
        String cpuRuntime = "";
        try {
            process.getOutputStream().flush();
            outputStreamWriter = new OutputStreamWriter(process.getOutputStream());
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            System.out.println("CpuRuntime_command = " + WINDOWS_CPU_RUNTIME_COMMAND);
            bufferedWriter.write(WINDOWS_CPU_RUNTIME_COMMAND);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            bufferedInputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            bufferedErrorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String bufferReader = checkBufferReadyState(bufferedInputReader, bufferedErrorReader, "cpuRuntime");
            if (bufferReader.equals("input")) {
                while ((line = bufferedInputReader.readLine()) != null) {
                    System.out.println("line = " + line);
                    if (line.startsWith("done")) {
                        cpuRuntime = line;
                        break;
                    }
                }
            }
            if (bufferReader.equals("error")) {
                while ((line = bufferedErrorReader.readLine()) != null) {
                    System.out.println("error line = " + line);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cpuRuntime;
    }

    private String getosArch(Process process) {
        String line = "";
        String osArch = "";
        try {
            process.getOutputStream().flush();
            outputStreamWriter = new OutputStreamWriter(process.getOutputStream());
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            System.out.println("osArch_command = " + WINDOWS_OSARCH_COMMAND);
            bufferedWriter.write(WINDOWS_OSARCH_COMMAND);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            bufferedInputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            bufferedErrorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String bufferReader = checkBufferReadyState(bufferedInputReader, bufferedErrorReader, "osArch");
            if (bufferReader.equals("input")) {
                while ((line = bufferedInputReader.readLine()) != null) {
                    System.out.println("line = " + line);
                    if (line.contains("bit")) {
                        osArch = line;
                        break;
                    }
                }
            }
            if (bufferReader.equals("error")) {
                while ((line = bufferedErrorReader.readLine()) != null) {
                    System.out.println("error line = " + line);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return osArch;
    }

    private String getSystemInfo(Process process) {
        String line = "";
        String systemInfo = "";
        try {
            process.getOutputStream().flush();
            outputStreamWriter = new OutputStreamWriter(process.getOutputStream());
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            System.out.println("SystemInfo_command = " + WINDOWS_SYSTEMINFO_COMMAND);
            bufferedWriter.write(WINDOWS_SYSTEMINFO_COMMAND);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            bufferedInputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            bufferedErrorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String bufferReader = checkBufferReadyState(bufferedInputReader, bufferedErrorReader, "systemInfo");
            
            if (bufferReader.equals("input")) {
                while ((line = bufferedInputReader.readLine()) != null) {
                    System.out.println("line= " + line);
                    if (line.startsWith("done")) {
                        systemInfo = line;
                        break;
                    }
                }
            }
            if (bufferReader.equals("error")||bufferReader.equals("")||bufferReader.equals(null)) {
                while ((line = bufferedErrorReader.readLine()) != null) {
                    System.out.println("error line cmd = " + line);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return systemInfo;
    }

    private String getSystemDate(Process process) {
        String line = "";
        String systemDate = "";
        try {
            process.getOutputStream().flush();
            outputStreamWriter = new OutputStreamWriter(process.getOutputStream());
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            System.out.println("SystemDate_command = " + WINDOWS_DATE_COMMAND);
            bufferedWriter.write(WINDOWS_DATE_COMMAND);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            bufferedInputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            bufferedErrorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String bufferReader = checkBufferReadyState(bufferedInputReader, bufferedErrorReader, "systemDate");
            if (bufferReader.equals("input")) {
                while ((line = bufferedInputReader.readLine()) != null) {
                    System.out.println("line = " + line);

                    if (line.startsWith("done")) {
                        systemDate = line;
                        break;
                    }
                }
            }
            if (bufferReader.equals("error")) {
                while ((line = bufferedErrorReader.readLine()) != null) {
                    System.out.println("error line = " + line);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return systemDate;
    }

    private String getSystemTime(Process process) {
        String line = "";
        String systemTime = "";
        try {
            process.getOutputStream().flush();
            outputStreamWriter = new OutputStreamWriter(process.getOutputStream());
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            System.out.println("SystemTime_command = " + WINDOWS_TIME_COMMAND);
            bufferedWriter.write(WINDOWS_TIME_COMMAND);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            bufferedInputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            bufferedErrorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String bufferReader = checkBufferReadyState(bufferedInputReader, bufferedErrorReader, "systemTime");
            if (bufferReader.equals("input")) {
                while ((line = bufferedInputReader.readLine()) != null) {
                    System.out.println("line = " + line);
                    if (line.contains("AM") || line.contains("PM")) {
                        systemTime = line;
                        break;
                    }
                }
            }
            if (bufferReader.equals("error")) {
                while ((line = bufferedErrorReader.readLine()) != null) {
                    System.out.println("error line = " + line);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return systemTime;
    }

    private String getPublicIP(Process process) {
        String line = "";
        String publicIP = "";
        try {
            process.getOutputStream().flush();
            outputStreamWriter = new OutputStreamWriter(process.getOutputStream());
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            System.out.println("PublicIP_command = " + WINDOWS_PUBLICIP_COMMAND);
            bufferedWriter.write(WINDOWS_PUBLICIP_COMMAND);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            bufferedInputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            bufferedErrorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String bufferReader = checkBufferReadyState(bufferedInputReader, bufferedErrorReader, "publicIP");
            if (bufferReader.equals("input")) {
                while ((line = bufferedInputReader.readLine()) != null) {
                    System.out.println("line = " + line);
                    if (line.startsWith("done")) {
                        publicIP = line;
                        break;
                    }
                }
            }
            if (bufferReader.equals("error")) {
                while ((line = bufferedErrorReader.readLine()) != null) {
                    System.out.println("error line = " + line);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return publicIP;
    }

    private String getDeviceInfo(Process process) {
        String line = "";
        String deviceInfo = "";
        try {
            process.getOutputStream().flush();
            outputStreamWriter = new OutputStreamWriter(process.getOutputStream());
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            System.out.println("DeviceInfo_command = " + WINDOWS_DEVICEINFO_COMMAND);
            bufferedWriter.write(WINDOWS_DEVICEINFO_COMMAND);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            bufferedInputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            bufferedErrorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String bufferReader = checkBufferReadyState(bufferedInputReader, bufferedErrorReader, "deviceInfo");
            if (bufferReader.equals("input")) {
                while ((line = bufferedInputReader.readLine()) != null) {

                    System.out.println("line = " + line);
                    if (line.trim().contains("DISKPART> done")) {
                        break;
                    }
                }
            }
            if (bufferReader.equals("error")) {
                while ((line = bufferedErrorReader.readLine()) != null) {
                    System.out.println("error line = " + line);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return deviceInfo;
    }

    private String getBIOSVersion(Process process) {
        String line = "";
        String biosVersion = "";
        try {
            process.getOutputStream().flush();
            outputStreamWriter = new OutputStreamWriter(process.getOutputStream());
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            System.out.println("biosVersion_command = " + WINDOWS_BIOS_VERSION_COMMAND);
            bufferedWriter.write(WINDOWS_BIOS_VERSION_COMMAND);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            bufferedInputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            bufferedErrorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String bufferReader = checkBufferReadyState(bufferedInputReader, bufferedErrorReader, "biosVersion");
            if (bufferReader.equals("input")) {
                while ((line = bufferedInputReader.readLine()) != null) {
                    System.out.println("line = " + line);
                    if (line.startsWith("done")) {
                        biosVersion = line;
                        break;
                    }
                }
            }
            if (bufferReader.equals("error")) {
                while ((line = bufferedErrorReader.readLine()) != null) {
                    System.out.println("error line = " + line);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return biosVersion;
    }

    private String getSystemManufacturer(Process process) {
        String line = "";
        String systemManufacturer = "";
        try {
            process.getOutputStream().flush();
            outputStreamWriter = new OutputStreamWriter(process.getOutputStream());
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            System.out.println("systemManufacturer_command = " + WINDOWS_SYSTEM_MANUFACTURER_COMMAND);
            bufferedWriter.write(WINDOWS_SYSTEM_MANUFACTURER_COMMAND);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            bufferedInputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            bufferedErrorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String bufferReader = checkBufferReadyState(bufferedInputReader, bufferedErrorReader, "systemManufacturer");
            if (bufferReader.equals("input")) {
                while ((line = bufferedInputReader.readLine()) != null) {
                    System.out.println("line = " + line);
                    if (line.startsWith("done")) {
                        systemManufacturer = line;
                        break;
                    }
                }
            }
            if (bufferReader.equals("error")) {
                while ((line = bufferedErrorReader.readLine()) != null) {
                    System.out.println("error line = " + line);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return systemManufacturer;
    }

    private String getRamDetails(Process process) {
        String line = "";
        String ramDetails = "";
        try {
            process.getOutputStream().flush();
            outputStreamWriter = new OutputStreamWriter(process.getOutputStream());
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            System.out.println("Get_command = " + WINDOWS_RAMDETAILS_COMMAND);
            bufferedWriter.write(WINDOWS_RAMDETAILS_COMMAND);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            bufferedInputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            bufferedErrorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String bufferReader = checkBufferReadyState(bufferedInputReader, bufferedErrorReader, "osName");
            if (bufferReader.equals("input")) {
                while ((line = bufferedInputReader.readLine()) != null) {
                    System.out.println("line = " + line);
                    if (line.startsWith("done")) {
                        ramDetails = line;
                        break;
                    }
                }
            }
            if (bufferReader.equals("error")) {
                while ((line = bufferedErrorReader.readLine()) != null) {
                    System.out.println("error line = " + line);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ramDetails;
    }
    public static String checkBufferReadyState(BufferedReader inputReader, BufferedReader errorReader, String methodname) {
        String message = "";
        try {
            int count = 0;
            boolean inputReaderReady;
            while (count < 3) {
                if (inputReader.ready() || errorReader.ready()) {
                    inputReaderReady = inputReader.ready();
                    if (inputReaderReady) {
                        message = "input";
                    } else {
                        message = "error";
                    }
                    return message;
                } else {
                    Thread.sleep(6 * 1000);
                    count++;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return message;
    }

    public static void killProcess(Process proc, String methodName) {
        int exitValue = 0;
        Process tempProc = null;
        try {
            if (proc != null) {
                exitValue = proc.exitValue();
                if (proc.isAlive()) {
                    tempProc = proc.destroyForcibly();
                }
            }
            if (tempProc != null && tempProc.isAlive()) {
                tempProc.destroy();
            }

        } catch (Exception ex) {
//            ex.printStackTrace();
        }
    }
}
