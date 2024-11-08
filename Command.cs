// Command
public interface ICommand
{
    void Execute();
}

// Receiver
public class Light
{
    public void TurnOn() => Console.WriteLine("The light is on.");
    public void TurnOff() => Console.WriteLine("The light is off.");
}

// ConcreteCommand
public class TurnOnCommand : ICommand
{
    private readonly Light _light;
    public TurnOnCommand(Light light) => _light = light;

    public void Execute() => _light.TurnOn();
}

public class TurnOffCommand : ICommand
{
    private readonly Light _light;
    public TurnOffCommand(Light light) => _light = light;

    public void Execute() => _light.TurnOff();
}

// Invoker  
public class RemoteControl
{
    private ICommand _command;

    public void SetCommand(ICommand command) => _command = command;
    public void PressButton() => _command.Execute();
}

// Client
public class Program
{
    public static void Main()
    {
        var light = new Light();
        var turnOnCommand = new TurnOnCommand(light);
        var turnOffCommand = new TurnOffCommand(light);
        
        var remote = new RemoteControl();
        
        // Bật đèn
        remote.SetCommand(turnOnCommand);
        remote.PressButton();

        // Tắt đèn
        remote.SetCommand(turnOffCommand);
        remote.PressButton();
    }
}
